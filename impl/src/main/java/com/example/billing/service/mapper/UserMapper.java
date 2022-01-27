package com.example.billing.service.mapper;

import com.example.billing.service.dto.UserDto;
import com.example.billing.service.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends AbstractMapper<UserEntity, UserDto>{
}
