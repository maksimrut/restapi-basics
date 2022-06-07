package com.epam.esm.exception;

public class CustomNotFoundException extends RuntimeException {

    private final Long resourceId;

    public CustomNotFoundException(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return resourceId;
    }
}
