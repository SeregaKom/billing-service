package com.example.billing.service.service;

import com.example.billing.service.entity.UserEntity;
import com.example.billing.service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity addUser(UserEntity user) {
        return userRepo.save(user);
    }

    public UserEntity updateUser(UserEntity user){
        return userRepo.save(user);
    }

    public UserEntity getUser(Long id) {
        return userRepo.findById(id).get();
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
