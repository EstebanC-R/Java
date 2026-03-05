package com.example.gestionar_series.exception;

public class SeriesNotFoundException extends RuntimeException {
    public SeriesNotFoundException(String message) {
        super(message);
    }
}
