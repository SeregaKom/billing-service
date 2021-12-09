package com.example.billing.service.service;

import com.example.billing.service.entity.UserTariffEntity;
import com.example.billing.service.repository.TariffRepo;
import com.example.billing.service.repository.UserRepo;
import com.example.billing.service.repository.UserTariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTariffService {
    @Autowired
    private UserTariffRepo userTariffRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TariffRepo tariffRepo;

    public UserTariffEntity addService(UserTariffEntity service, Long userId, Long tariffId) {
        // TODO: запилить проверку, что такой пользователь и тариф существует
        var user = userRepo.findById(userId).get();
        var tariff = tariffRepo.findById(tariffId).get();

        service.setUser(user);
        service.setTariff(tariff);

        return userTariffRepo.save(service);
    }

    public UserTariffEntity updateService(UserTariffEntity service, Long userId, Long tariffId) {
        // TODO: запилить проверку, что такой пользователь и тариф существует
        var user = userRepo.findById(userId).get();
        var tariff = tariffRepo.findById(tariffId).get();

        service.setUser(user);
        service.setTariff(tariff);

        return userTariffRepo.save(service);
    }

    public UserTariffEntity getService(Long id) {
        return userTariffRepo.findById(id).get();
    }

    public Long deleteService(Long id) {
        userTariffRepo.deleteById(id);
        return id;
    }
}
