package com.example.billing.service.service;

import com.example.billing.service.entity.TariffEntity;
import com.example.billing.service.entity.UserEntity;
import com.example.billing.service.repository.TariffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TariffService {
    private final TariffRepo tariffRepo;

    /**Добавить тариф
     * @param tariff Тариф
     * @return
     */
    public TariffEntity addTariff(TariffEntity tariff) {
        return tariffRepo.save(tariff);
    }

    /**Обновить тариф
     * @param tariff Тариф
     * @return
     */
    public TariffEntity updateTariff(TariffEntity tariff){
        return tariffRepo.save(tariff);
    }

    /**Получить тариф
     * @param id Идентификатор тарифа
     * @return
     */
    public TariffEntity getTariff(Long id) {
        return tariffRepo.findById(id).get();
    }

    /**Удалить тариф
     * @param id Идентификатор тарифа
     * @return
     */
    public Long deleteTariff(Long id) {
        tariffRepo.deleteById(id);
        return id;
    }
}
