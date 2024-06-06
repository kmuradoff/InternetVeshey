package ru.unn.internetveshey.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends RestException {
    public UnauthorizedException(String code, String message) {
        super(message, code, HttpStatus.UNAUTHORIZED);
    }
}