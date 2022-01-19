package com.example.billing.service.controller;

import com.example.billing.service.entity.TariffEntity;
import com.example.billing.service.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tariffs")
public class TariffController {
    private final TariffService tariffService;

    @PostMapping
    public ResponseEntity addTariff(@RequestBody TariffEntity tariff) {
        return ResponseEntity.ok(tariffService.addTariff(tariff));
    }

    @PutMapping
    public ResponseEntity updateTariff(@RequestBody TariffEntity tariff) {
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
