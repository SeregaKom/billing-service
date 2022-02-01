package com.example.billing.service.controller;

import com.example.billing.service.entity.Service;
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
    public ResponseEntity addService(@RequestBody Service service, @RequestParam Long userId, @RequestParam Long tariffId) {
        return ResponseEntity.ok(userTariffService.addService(service, userId, tariffId));
    }

    @PutMapping
    public ResponseEntity updateService(@RequestBody Service service, @RequestParam Long userId, @RequestParam Long tariffId) {
        return ResponseEntity.ok(userTariffService.updateService(service, userId, tariffId));
    }

    @GetMapping
    public ResponseEntity getService(@RequestParam Long id) {
        return ResponseEntity.ok(userTariffService.getService(id));
    }

    @DeleteMapping
    public ResponseEntity deleteService(@RequestParam Long id) {
        return ResponseEntity.ok(userTariffService.deleteService(id));
    }
}
