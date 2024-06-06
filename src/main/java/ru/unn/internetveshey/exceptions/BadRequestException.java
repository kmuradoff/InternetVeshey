package ru.unn.internetveshey.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RestException {
    public BadRequestException(String code, String message) {
        super(code, message, HttpStatus.BAD_REQUEST);
    }
}