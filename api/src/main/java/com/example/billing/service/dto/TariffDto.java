package com.example.billing.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class TariffDto {
    private Long id;

    private String name;

    private double pricePerMinute;
}
