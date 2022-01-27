package com.example.billing.service.service;
import com.example.billing.service.entity.UserTariffEntity;
import com.example.billing.service.repository.UserRepo;
import com.example.billing.service.entity.UserEntity;
import com.example.billing.service.repository.UserTariffRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class BalanceService {
    private final UserRepo userRepo;
    private final UserTariffRepo userTariffRepo;

    /**
     * Пополнить баланс
     *
     * @param userId Идентификатор пользователя
     * @param value  Сумма для зачислления
     * @return
     */
    public Optional<Double> topUpBalance(Long userId, Double value) {

        return userRepo.findById(userId)
                .map(user -> user.setBalance(user.getBalance() + value))
                .map(userRepo::save)
                .map(UserEntity::getBalance)
                .map(balance -> updateTariffs(userId, balance));
    }

    private Double updateTariffs(Long userId, Double balance) {
        if (balance <= 0) {
            return balance;
        }

        var services = userTariffRepo.findByUserId(userId).stream()
                .filter(service -> !service.getIsActivated())
                .peek(service -> {
                    service.setIsActivated(Boolean.TRUE);
                    log.info(String.format("[%s] Услуга по тарифу %s восстановлена", userId, service.getTariff().getName()));
                })
                .collect(Collectors.toList());
        userTariffRepo.saveAll(services);

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

    //TODO Заюзать спринговый шедулер
    private void writeOffAmount() {
        var allServices = StreamSupport.stream(userTariffRepo.findAll().spliterator(), false);
        var users = userRepo.findAll();
        for (UserEntity user : users
        ) {

            if (user.getBalance() <= 0) {
                log.info(String.format("[%s] Услуги приостановлены. Недостаточно средств", user));
                continue;
            }

            var activatedUserServices = allServices
                    .filter(service -> Objects.equals(service.getUser().getId(), user.getId()) && service.getIsActivated()).toList();

            var sum = activatedUserServices.stream()
                    .map(service -> service.getTariff().getPricePerMinute())
                    .mapToDouble(value -> value).sum();

            var newBalance = user.getBalance() - sum;

            user.setBalance(newBalance);

            userRepo.save(user);

            log.info(String.format("[%s] Списание средств %.2f", user, sum));

            if (newBalance <= 0) {
                deactivateServices(activatedUserServices);
            }
        }
    }

    private void deactivateServices(List<UserTariffEntity> activatedUserServices) {
        for (var service :
                activatedUserServices) {
            service.setIsActivated(false);
            userTariffRepo.save(service);

            log.info(String.format("[%s] Недостаточно средств на счету. Услуга по тарифу %s отключена",
                    service.getUser(), service.getTariff().getName()));
        }
    }
}
