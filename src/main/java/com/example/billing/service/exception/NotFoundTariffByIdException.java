package com.example.billing.service.exception;

public class NotFoundTariffByIdException extends RuntimeException{
    public NotFoundTariffByIdException(Long id) {
        super(String.format("Не удалось найти тариф по идентификатору %s", id));
    }
}
