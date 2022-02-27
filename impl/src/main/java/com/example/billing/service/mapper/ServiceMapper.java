package com.example.billing.service.mapper;

import com.example.billing.service.dto.ServiceDto;
import com.example.billing.service.entity.Turn;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceMapper extends AbstractMapper<Turn, ServiceDto> {
    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);
}