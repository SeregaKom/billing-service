package com.example.billing.service.repository;

import com.example.billing.service.entity.UserTariffEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserTariffRepo extends CrudRepository<UserTariffEntity, Long> {
}
