package com.example.billing.service.mapper;

import com.example.billing.service.dto.ServiceDto;
import com.example.billing.service.entity.Service;
import org.mapstruct.Mapper;

@Mapper
public interface ServiceMapper extends AbstractMapper<Service, ServiceDto> {
}