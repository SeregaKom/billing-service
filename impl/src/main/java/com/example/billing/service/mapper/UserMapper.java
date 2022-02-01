package com.example.billing.service.mapper;

import com.example.billing.service.dto.UserDto;
import com.example.billing.service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends AbstractMapper<User, UserDto>{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
}
