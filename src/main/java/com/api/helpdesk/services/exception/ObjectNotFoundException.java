package com.api.helpdesk.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }
}
