package com.example.billing.service.repository;

import com.example.billing.service.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
