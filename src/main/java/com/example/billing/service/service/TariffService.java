package com.example.billing.service.service;

import com.example.billing.service.entity.TariffEntity;
import com.example.billing.service.entity.UserEntity;
import com.example.billing.service.repository.TariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TariffService {
    @Autowired
    private TariffRepo tariffRepo;

    public TariffEntity addTariff(TariffEntity tariff) {
        return tariffRepo.save(tariff);
    }

    public TariffEntity updateTariff(TariffEntity tariff){
        return tariffRepo.save(tariff);
    }

    public TariffEntity getTariff(Long id) {
        return tariffRepo.findById(id).get();
    }

    public Long deleteTariff(Long id) {
        tariffRepo.deleteById(id);
        return id;
    }
}
