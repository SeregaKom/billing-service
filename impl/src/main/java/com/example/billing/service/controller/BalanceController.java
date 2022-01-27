package com.example.billing.service.controller;

import com.example.billing.service.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/balances")
public class BalanceController {
    private final BalanceService balanceService;

    @PutMapping
    public ResponseEntity<String> topUpBalance(@RequestParam Long userId, @RequestParam Double value) {
        return balanceService.topUpBalance(userId, value)
                //TODO dto ненадо на фронт отвечать текстом
                .map(x -> ResponseEntity.ok(String.format("Баланс успешно пополнен и составляет %.2f", x)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
