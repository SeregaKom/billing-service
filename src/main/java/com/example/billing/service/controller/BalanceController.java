package com.example.billing.service.controller;

import com.example.billing.service.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balances")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;

    @PutMapping
    public ResponseEntity topUpBalance(@RequestParam Long userId, @RequestParam Double value) {
        try {
            var newBalance = balanceService.topUpBalance(userId, value);
            return ResponseEntity.ok(String.format("Баланс успешно пополнен и составляет %.2f", newBalance));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(String.format("Не удалось пополнить баланс. Ошибка: %s", e.getMessage()));
        }
    }
}
