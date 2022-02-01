package com.example.billing.service.mapper;

import com.example.billing.service.dto.TariffDto;
import com.example.billing.service.entity.Tariff;
import org.mapstruct.Mapper;

@Mapper
public interface TariffMapper extends AbstractMapper<Tariff, TariffDto> {
}
