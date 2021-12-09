package com.example.billing.service.controller;

import com.example.billing.service.entity.UserTariffEntity;
import com.example.billing.service.service.UserTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("services")
public class UserTariffController {
    @Autowired
    private UserTariffService userTariffService;

    @PostMapping
    public ResponseEntity addService(@RequestBody UserTariffEntity service, @RequestParam Long userId, @RequestParam Long tariffId) {
        try {
            return ResponseEntity.ok(userTariffService.addService(service, userId, tariffId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updateService(@RequestBody UserTariffEntity service, @RequestParam Long userId, @RequestParam Long tariffId) {
        try {
            return ResponseEntity.ok(userTariffService.addService(service, userId, tariffId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getService(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userTariffService.getService(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteService(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userTariffService.deleteService(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
