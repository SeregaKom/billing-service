package com.example.billing.service.controller;

import com.example.billing.service.entity.Tariff;
import com.example.billing.service.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tariffs")
public class TariffController {
    private final TariffService tariffService;

    @PostMapping
    public ResponseEntity addTariff(@RequestBody Tariff tariff) {
        return ResponseEntity.ok(tariffService.addTariff(tariff));
    }

    @PutMapping
    public ResponseEntity updateTariff(@RequestBody Tariff tariff) {
        return ResponseEntity.ok(tariffService.updateTariff(tariff));
    }

    @GetMapping
    public ResponseEntity getTariff(@RequestParam Long id) {
        return ResponseEntity.ok(tariffService.getTariff(id));
    }

    @DeleteMapping
    public ResponseEntity deleteTariff(@RequestParam Long id) {
        return ResponseEntity.ok(tariffService.deleteTariff(id));
    }
}
