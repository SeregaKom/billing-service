package com.example.billing.service.service;

import com.example.billing.service.entity.UserTariffEntity;
import com.example.billing.service.exception.NotFoundTariffByIdExtension;
import com.example.billing.service.exception.NotFoundUserByIdExtension;
import com.example.billing.service.repository.TariffRepo;
import com.example.billing.service.repository.UserRepo;
import com.example.billing.service.repository.UserTariffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTariffService {
    private final UserTariffRepo userTariffRepo;
    private final UserRepo userRepo;
    private final TariffRepo tariffRepo;

    /**
     * Подключить услугу
     *
     * @param service  Услуга
     * @param userId   Идентификатор пользователя
     * @param tariffId Идентификатор тарифа
     * @return
     */
    public UserTariffEntity addService(UserTariffEntity service, Long userId, Long tariffId)
            throws NotFoundUserByIdExtension, NotFoundTariffByIdExtension {
        var user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundUserByIdExtension(userId));
        var tariff = tariffRepo.findById(tariffId)
                .orElseThrow(() -> new NotFoundTariffByIdExtension(tariffId));

        service.setUser(user);
        service.setTariff(tariff);

        return userTariffRepo.save(service);
    }

    /**
     * Обновить услугу
     *
     * @param service  Услуга
     * @param userId   Идентификатор пользователя
     * @param tariffId Идентификатор тарифа
     * @return
     */
    public UserTariffEntity updateService(UserTariffEntity service, Long userId, Long tariffId)
            throws NotFoundUserByIdExtension, NotFoundTariffByIdExtension {
        var user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundUserByIdExtension(userId));
        var tariff = tariffRepo.findById(tariffId)
                .orElseThrow(() -> new NotFoundTariffByIdExtension(tariffId));

        service.setUser(user);
        service.setTariff(tariff);

        return userTariffRepo.save(service);
    }

    /**
     * Получить услугу
     *
     * @param id Идентификатор услуги
     * @return
     */
    public UserTariffEntity getService(Long id) {
        return userTariffRepo.findById(id).get();
    }

    /**
     * Удалить услугу
     *
     * @param id Идентификатор услуги
     * @return
     */
    public Long deleteService(Long id) {
        userTariffRepo.deleteById(id);
        return id;
    }
}
