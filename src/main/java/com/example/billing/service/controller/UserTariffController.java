package com.example.billing.service.controller;

import com.example.billing.service.entity.UserTariffEntity;
import com.example.billing.service.exception.NotFoundServiceByIdException;
import com.example.billing.service.exception.NotFoundTariffByIdException;
import com.example.billing.service.exception.NotFoundUserByIdException;
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
    public ResponseEntity addService(@RequestBody UserTariffEntity service, @RequestParam Long userId, @RequestParam Long tariffId) {
        try {
            return ResponseEntity.ok(userTariffService.addService(service, userId, tariffId));
        } catch (NotFoundUserByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NotFoundTariffByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updateService(@RequestBody UserTariffEntity service, @RequestParam Long userId, @RequestParam Long tariffId) {
        try {
            return ResponseEntity.ok(userTariffService.updateService(service, userId, tariffId));
        } catch (NotFoundUserByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NotFoundTariffByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getService(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userTariffService.getService(id));
        } catch (NotFoundServiceByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteService(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userTariffService.deleteService(id));
        } catch (NotFoundServiceByIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
