package com.example.billing.service.repository;

import com.example.billing.service.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepo extends JpaRepository<Tariff, Long> {
}
