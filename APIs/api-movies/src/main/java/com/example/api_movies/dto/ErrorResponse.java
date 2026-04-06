package com.example.api_movies.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

/**
    % DTO estándar para TODAS las respuestas de error de la API

    % Ejemplos de uso:
    % - 400 Bad Request (validación)
    % - 404 Not Found (recurso no existe)
    % - 409 Conflict (duplicate review)
    % - 500 Internal Server Error (error inesperado)
 */

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    /*
        ? Código HTTP del error (400, 404, 409, 500, etc)
        ? El cliente usa esto para saber qué tipo de error es
     */
    private int status;

    /*
        $ Mensaje AMIGABLE para el usuario/cliente
        $ Ejemplo: "El usuario ya escribió una review para esta película"
        $ NO debe ser técnico
    */
    private String message;

    /*
     * Código de error para programadores/logs
     * Ejemplo: "DUPLICATE_REVIEW", "USER_NOT_FOUND", "VALIDATION_ERROR"
     * Útil para debugging y análisis de logs
    */
    private String error;

    /*
        % Cuándo ocurrió exactamente el error
        % Útil para auditoría y troubleshooting
    */
    private OffsetDateTime timestamp;

    /*
        ! Constructor alternativo sin timestamp
        ! El timestamp se asigna automáticamente al momento de crear el objeto
    */
    public ErrorResponse(int status, String message, String error) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.timestamp = OffsetDateTime.now();  // ← Ahora automáticamente
    }
}
