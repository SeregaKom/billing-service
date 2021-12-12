package com.example.billing.service.exception;

public class NotFoundUserByIdException extends RuntimeException {
    public NotFoundUserByIdException(Long id) {
        super(String.format("Не удалось найти пользователя по идентификатору %s", id));
    }
}
