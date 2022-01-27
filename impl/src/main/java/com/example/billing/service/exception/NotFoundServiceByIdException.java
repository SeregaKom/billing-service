package com.example.billing.service.exception;

public class NotFoundServiceByIdException extends RuntimeException{
    public NotFoundServiceByIdException(Long id) {
        super(String.format("Не удалось найти услугу по идентификатору %s", id));
    }
}
