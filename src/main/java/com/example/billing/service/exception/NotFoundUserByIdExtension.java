package com.example.billing.service.exception;

public class NotFoundUserByIdExtension extends RuntimeException {
    public NotFoundUserByIdExtension(Long userId) {
        super(String.format("Не удалось найти пользователя по идентификатору %s", userId));
    }
}
