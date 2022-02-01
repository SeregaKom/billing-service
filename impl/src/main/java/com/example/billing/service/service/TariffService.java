package com.example.billing.service.service;

import com.example.billing.service.entity.Tariff;
import com.example.billing.service.repository.TariffRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TariffService {
    private final TariffRepo tariffRepo;

    /**Добавить тариф
     * @param tariff Тариф
     * @return
     */
    public Tariff addTariff(Tariff tariff) {
        return tariffRepo.save(tariff);
    }

    /**Обновить тариф
     * @param tariff Тариф
     * @return
     */
    public Tariff updateTariff(Tariff tariff){
        return tariffRepo.save(tariff);
    }

    /**Получить тариф
     * @param id Идентификатор тарифа
     * @return
     */
    public Tariff getTariff(Long id) {
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
