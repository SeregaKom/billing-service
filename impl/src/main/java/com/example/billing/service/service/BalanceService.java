package com.example.billing.service.service;

import com.example.billing.service.entity.Service;
import com.example.billing.service.entity.User;
import com.example.billing.service.repository.UserRepo;
import com.example.billing.service.repository.UserTariffRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
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
                .map(User::getBalance)
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

    @Scheduled(cron = "0 0/1 * * * *")
    private void writeOffAmount() {
        var allServices = userTariffRepo.findAll();
        var users = userRepo.findAll();
        for (User user : users
        ) {

            try {
                if (user.getBalance() <= 0) {
                    log.info(String.format("[%s] Услуги приостановлены. Недостаточно средств", user));
                    continue;
                }

                var activatedUserServices = allServices.stream()
                        .filter(service -> Objects.equals(service.getUser().getId(), user.getId())
                                && service.getIsActivated())
                        .toList();

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
            catch (RuntimeException e){
                log.error(e.getMessage());
                throw e;
            }
        }
    }

    private void deactivateServices(List<Service> activatedUserServices) {
        for (var service :
                activatedUserServices) {
            service.setIsActivated(false);
            userTariffRepo.save(service);

            log.info(String.format("[%s] Недостаточно средств на счету. Услуга по тарифу %s отключена",
                    service.getUser(), service.getTariff().getName()));
        }
    }
}
