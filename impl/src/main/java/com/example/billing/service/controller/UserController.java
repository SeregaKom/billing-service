package com.example.billing.service.controller;

import com.example.billing.service.dto.UserDto;
import com.example.billing.service.mapper.UserMapper;
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
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        var user = userService.addUser(UserMapper.INSTANCE.toDomainModel(userDto));

        return ResponseEntity.ok(UserMapper.INSTANCE.toDto(user));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        var user = userService.updateUser(UserMapper.INSTANCE.toDomainModel(userDto));

        return ResponseEntity.ok(UserMapper.INSTANCE.toDto(user));
    }

    @GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam Long id) {
        var user = userService.getUser(id);

        return ResponseEntity.ok(UserMapper.INSTANCE.toDto(user));
    }

    @DeleteMapping
    public ResponseEntity<Long> deleteUser(@RequestParam Long id) {

        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
