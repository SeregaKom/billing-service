package com.example.billing.service.service;

import com.example.billing.service.entity.Turn;
import com.example.billing.service.exception.NotFoundServiceByIdException;
import com.example.billing.service.exception.NotFoundTariffByIdException;
import com.example.billing.service.exception.NotFoundUserByIdException;
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
     * @param service Услуга
     * @param userId   Идентификатор пользователя
     * @param tariffId Идентификатор тарифа
     * @return
     */
    public Turn addService(Turn service, Long userId, Long tariffId)
            throws NotFoundUserByIdException, NotFoundTariffByIdException {
        var user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundUserByIdException(userId));
        var tariff = tariffRepo.findById(tariffId)
                .orElseThrow(() -> new NotFoundTariffByIdException(tariffId));

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
    public Turn updateService(Turn service, Long userId, Long tariffId)
            throws NotFoundUserByIdException, NotFoundTariffByIdException {
        var user = userRepo.findById(userId)
                .orElseThrow(() -> new NotFoundUserByIdException(userId));
        var tariff = tariffRepo.findById(tariffId)
                .orElseThrow(() -> new NotFoundTariffByIdException(tariffId));

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
    public Turn getService(Long id) {
        return userTariffRepo.findById(id).orElseThrow(()-> new NotFoundServiceByIdException(id));
    }

    /**
     * Удалить услугу
     *
     * @param id Идентификатор услуги
     * @return
     */
    public Long deleteService(Long id) {
        userTariffRepo.findById(id).orElseThrow(()-> new NotFoundServiceByIdException(id));
        userTariffRepo.deleteById(id);
        return id;
    }
}
