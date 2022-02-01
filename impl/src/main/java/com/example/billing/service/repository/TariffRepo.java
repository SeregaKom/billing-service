package com.example.billing.service.repository;

import com.example.billing.service.entity.Tariff;
import org.springframework.data.repository.CrudRepository;

public interface TariffRepo extends CrudRepository<Tariff, Long> {
}
