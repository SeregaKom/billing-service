package com.example.billing.service.mapper;

import com.example.billing.service.dto.TariffDto;
import com.example.billing.service.entity.Tariff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TariffMapper extends AbstractMapper<Tariff, TariffDto> {
    TariffMapper INSTANCE = Mappers.getMapper(TariffMapper.class);
}
