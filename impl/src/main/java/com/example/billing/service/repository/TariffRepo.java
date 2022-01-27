package com.example.billing.service.repository;

import com.example.billing.service.entity.TariffEntity;
import org.springframework.data.repository.CrudRepository;

public interface TariffRepo extends CrudRepository<TariffEntity, Long> {
}
