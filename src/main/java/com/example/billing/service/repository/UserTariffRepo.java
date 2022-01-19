package com.example.billing.service.repository;

import com.example.billing.service.entity.UserTariffEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTariffRepo extends CrudRepository<UserTariffEntity, Long> {
    List<UserTariffEntity> findByUserId(Long userId);
}