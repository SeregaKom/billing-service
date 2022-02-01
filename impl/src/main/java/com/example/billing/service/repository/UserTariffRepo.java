package com.example.billing.service.repository;

import com.example.billing.service.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTariffRepo extends JpaRepository<Service, Long> {
    List<Service> findByUserId(Long userId);
}