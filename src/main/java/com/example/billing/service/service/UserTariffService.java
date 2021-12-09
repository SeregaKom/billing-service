package com.example.billing.service.service;

import com.example.billing.service.entity.UserTariffEntity;
import com.example.billing.service.repository.UserTariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTariffService {
    @Autowired
    private UserTariffRepo userTariffRepo;

    public UserTariffEntity addUserTariff(UserTariffEntity userTariff) {
        return userTariffRepo.save(userTariff);
    }

    public UserTariffEntity getUserTariff(Long id) {
        return userTariffRepo.findById(id).get();
    }

    public Long deleteUserTariff(Long id) {
        userTariffRepo.deleteById(id);
        return id;
    }
}
