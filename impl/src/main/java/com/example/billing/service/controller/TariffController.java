package com.example.billing.service.controller;

import com.example.billing.service.dto.TariffDto;
import com.example.billing.service.entity.Tariff;
import com.example.billing.service.mapper.TariffMapper;
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
    public ResponseEntity<TariffDto> addTariff(@RequestBody TariffDto tariffDto) {
        var tariff = tariffService.addTariff(TariffMapper.INSTANCE.toDomainModel(tariffDto));

        return ResponseEntity.ok(TariffMapper.INSTANCE.toDto(tariff));
    }

    @PutMapping
    public ResponseEntity<TariffDto> updateTariff(@RequestBody TariffDto tariffDto) {
        var tariff = tariffService.updateTariff(TariffMapper.INSTANCE.toDomainModel(tariffDto));

        return ResponseEntity.ok(TariffMapper.INSTANCE.toDto(tariff));
    }

    @GetMapping
    public ResponseEntity<TariffDto> getTariff(@RequestParam Long id) {

        return ResponseEntity.ok(TariffMapper.INSTANCE.toDto(tariffService.getTariff(id)));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteTariff(@RequestParam Long id) {

        return ResponseEntity.ok(tariffService.deleteTariff(id));
    }
}
