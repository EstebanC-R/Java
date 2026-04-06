package com.esteban.gestion_tickets.exception;

public class StatusNotFoundException extends RuntimeException {
    public StatusNotFoundException(String message) {
        super(message);
    }
}
