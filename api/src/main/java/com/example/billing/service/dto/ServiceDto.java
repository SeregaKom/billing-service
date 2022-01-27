package com.example.billing.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ServiceDto {

    private Long id;

    private Boolean isActivated;

    private UserDto user;

    private TariffDto tariff;
}
