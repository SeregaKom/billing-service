package com.example.billing.service.repository;

import com.example.billing.service.entity.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTariffRepo extends CrudRepository<Service, Long> {
    List<Service> findByUserId(Long userId);
}