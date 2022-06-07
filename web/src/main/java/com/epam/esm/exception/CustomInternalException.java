package com.epam.esm.exception;

public class CustomInternalException extends RuntimeException {

    private String message;

    public CustomInternalException(String message) {
        this.message = message;
    }
}
