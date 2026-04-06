package com.esteban.gestion_tickets.exception;

public class TitleNotFoundException extends RuntimeException {
    public TitleNotFoundException(String message) {
        super(message);
    }
}
