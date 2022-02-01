package com.example.billing.service.repository;

import com.example.billing.service.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTariffRepo extends JpaRepository<Turn, Long> {
    List<Turn> findByUserId(Long userId);
}