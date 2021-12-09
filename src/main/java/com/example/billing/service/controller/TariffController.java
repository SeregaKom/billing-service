package com.example.billing.service.controller;

import com.example.billing.service.entity.TariffEntity;
import com.example.billing.service.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tariffs")
public class TariffController {
    @Autowired
    private TariffService tariffService;

    @PostMapping
    public ResponseEntity addTariff(@RequestBody TariffEntity tariff) {
        try {
            return ResponseEntity.ok(tariffService.addTariff(tariff));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updateTariff(@RequestBody TariffEntity tariff) {
        try {
            return ResponseEntity.ok(tariffService.updateTariff(tariff));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getTariff(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(tariffService.getTariff(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteTariff(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(tariffService.deleteTariff(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
