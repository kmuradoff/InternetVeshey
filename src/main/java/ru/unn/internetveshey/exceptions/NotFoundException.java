package ru.unn.internetveshey.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RestException {

    public NotFoundException(String code, String message) {
        super(code, message, HttpStatus.NOT_FOUND);
    }
}