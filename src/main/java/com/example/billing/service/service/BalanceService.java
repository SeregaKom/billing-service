package com.example.billing.service.service;

import com.example.billing.service.entity.UserEntity;
import com.example.billing.service.entity.UserTariffEntity;
import com.example.billing.service.repository.UserRepo;
import com.example.billing.service.repository.UserTariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.StreamSupport;

@Service
public class BalanceService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserTariffRepo userTariffRepo;

    public Double topUpBalance(Long userId, Double value) {
        var user = userRepo.findById(userId).get();

        var balance = user.getBalance() + value;
        user.setBalance(balance);

        userRepo.save(user);

        return balance;
    }

    @PostConstruct
    private void init() {
        var timer = new Timer();
        var timerTask = new TimerTask() {
            @Override
            public void run() {
                writeOffAmount();
            }
        };
        timer.schedule(timerTask, 0, 60000);
    }

    private void writeOffAmount() {
        var allServices = StreamSupport.stream(userTariffRepo.findAll().spliterator(), false);
        var users = userRepo.findAll();
        for (UserEntity user : users
        ) {

            if (user.getBalance() <= 0) {
                System.out.println(String.format("[%s] Услуги приостановлены. Недостаточно средств %.2f", user, user.getBalance()));
                continue;
            }

            var activatedUserServices = allServices
                    .filter(service -> service.getUser().getId() == user.getId() && service.getIsActivated()).toList();

            var sum = activatedUserServices.stream()
                    .map(service -> service.getTariff().getPricePerMinute())
                    .mapToDouble(value -> value).sum();

            var newBalance = user.getBalance() - sum;

            user.setBalance(newBalance);

            userRepo.save(user);

            System.out.println(String.format("[%s] Списание средств %.2f. Баланс составляет %.2f", user, sum, newBalance));

            if (newBalance <= 0) {
                deactivateServices(activatedUserServices);
            }
        }
    }

    private void deactivateServices(List<UserTariffEntity> activatedUserServices) {
        for (var service : activatedUserServices
        ) {
            service.setIsActivated(false);
            userTariffRepo.save(service);
            System.out.println(String.format("[%s] Недостаточно средств на счету. Услуга по тарифу %s отключена",
                    service.getUser(), service.getTariff().getName()));
        }
    }
}
