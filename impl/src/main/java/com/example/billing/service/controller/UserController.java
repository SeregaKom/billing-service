package com.example.billing.service.controller;

import com.example.billing.service.entity.UserEntity;
import com.example.billing.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping
    public ResponseEntity getUser(@RequestParam Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
