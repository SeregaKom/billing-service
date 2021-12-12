package com.example.billing.service.exception;

public class NotFoundTariffByIdExtension extends RuntimeException{
    public NotFoundTariffByIdExtension(Long tariffId) {
        super(String.format("Не удалось найти тариф по идентификатору %s", tariffId));
    }
}
