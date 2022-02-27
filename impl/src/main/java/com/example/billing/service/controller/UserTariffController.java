package com.example.billing.service.controller;

import com.example.billing.service.dto.ServiceDto;
import com.example.billing.service.mapper.ServiceMapper;
import com.example.billing.service.service.UserTariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("services")
public class UserTariffController {
    private final UserTariffService userTariffService;

    @PostMapping
    public ResponseEntity<ServiceDto> addService(
            @RequestBody ServiceDto serviceDto,
            @RequestParam Long userId,
            @RequestParam Long tariffId) {
        var service = userTariffService.addService(ServiceMapper.INSTANCE.toDomainModel(serviceDto), userId, tariffId);

        return ResponseEntity.ok(ServiceMapper.INSTANCE.toDto(service));
    }

    @PutMapping
    public ResponseEntity<ServiceDto> updateService(
            @RequestBody ServiceDto serviceDto,
            @RequestParam Long userId,
            @RequestParam Long tariffId) {
        var service = userTariffService.updateService(ServiceMapper.INSTANCE.toDomainModel(serviceDto), userId, tariffId);

        return ResponseEntity.ok(ServiceMapper.INSTANCE.toDto(service));
    }

    @GetMapping
    public ResponseEntity<ServiceDto> getService(@RequestParam Long id) {
        var service = userTariffService.getService(id);

        return ResponseEntity.ok(ServiceMapper.INSTANCE.toDto(service));
    }

    @DeleteMapping
    public ResponseEntity deleteService(@RequestParam Long id) {

        return ResponseEntity.ok(userTariffService.deleteService(id));
    }
}
