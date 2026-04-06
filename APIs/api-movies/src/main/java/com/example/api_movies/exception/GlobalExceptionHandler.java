package com.example.api_movies.exception;

import com.example.api_movies.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/*
| Código | Nombre        | Cuándo usarlo                | ResponseEntity                                   |
|------- |--------------|------------------------------|--------------------------------------------------|
| 200    | OK           | GET exitoso                  | ResponseEntity.ok(data)                          |
| 201    | CREATED      | POST exitoso (recurso creado)| ResponseEntity.status(CREATED).body(data)        |
| 204    | NO_CONTENT   | DELETE exitoso               | ResponseEntity.noContent().build()               |
| 400    | BAD_REQUEST  | Datos inválidos              | ResponseEntity.status(BAD_REQUEST).body(error)   |
| 401    | UNAUTHORIZED | Sin autenticación            | ResponseEntity.status(UNAUTHORIZED).body(error)  |
| 403    | FORBIDDEN    | Sin permisos                 | ResponseEntity.status(FORBIDDEN).body(error)     |
| 404    | NOT_FOUND    | Recurso no existe            | ResponseEntity.status(NOT_FOUND).body(error)     |
| 500    | SERVER_ERROR | Error inesperado del servidor| ResponseEntity.status(INTERNAL_SERVER_ERROR).body(error) |
|
| Recordatorios:
| - En Controllers normalmente se devuelven respuestas exitosas (200, 201, 204).
| - En GlobalExceptionHandler se manejan los errores (400, 401, 403, 404, 500).
| - @ExceptionHandler captura una excepción específica.
| - @RestControllerAdvice permite manejar esas excepciones de forma global.
*/


/**
 * Manejador centralizado de excepciones para toda la API
 *
 * @RestControllerAdvice:
 * - Intercepta TODAS las excepciones de TODOS los controllers
 * - Aplica automáticamente si una excepción no es capturada en el controller
 *
 * Beneficios:
 * - UN SOLO LUGAR para manejar errores
 * - Respuestas consistentes
 * - Código limpio en controllers (sin try/catch)
 * - Fácil de mantener y extender
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja: UserNotFoundException
     * Retorna: 404 Not Found
     * Cuando: El usuario no existe
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException e) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),      // 404
                e.getMessage(),                    // "No se encontró usuario..."
                "USER_NOT_FOUND"                   // Código para logs
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    /**
     * Maneja: MovieNotFoundException
     * Retorna: 404 Not Found
     * Cuando: La película no existe
     */
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieNotFound(MovieNotFoundException e) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                "MOVIE_NOT_FOUND"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    /**
     * Maneja: ReviewNotFoundException
     * Retorna: 404 Not Found
     * Cuando: La review no existe
     */
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleReviewNotFound(
            ReviewNotFoundException e) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                "REVIEW_NOT_FOUND"
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    /**
     * Maneja: DuplicateReviewException
     * Retorna: 409 Conflict
     * Cuando: El usuario intenta escribir 2 reviews de la misma película
     *
     * Status 409 significa: "Hay un conflicto"
     * Específicamente: "Algo que intentas crear ya existe"
     */
    @ExceptionHandler(DuplicateReviewException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateReview(DuplicateReviewException e) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),       // 409
                e.getMessage(),                    // "El usuario ya escribió..."
                "DUPLICATE_REVIEW"                 // Código para logs
        );

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(error);
    }

    /**
     * Maneja: MethodArgumentNotValidException
     * Retorna: 400 Bad Request
     * Cuando: @Valid falla (validaciones de DTO)
     *
     * Ejemplo: @NotBlank, @Size, @Min, @Max fallan
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {

        // Extrae el PRIMER error de validación
        String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .orElse("Error de validación");

        // Ejemplo de message resultante:
        // "rating: La calificación maxima es 10"

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),    // 400
                message,
                "VALIDATION_ERROR"
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    /**
     * Maneja: HttpMessageNotReadableException
     * Retorna: 400 Bad Request
     * Cuando: JSON inválido o enum inválido
     *
     * Ejemplos:
     * - "genre": "ACTIO" (enum inválido)
     * - "duration": "abc" (tipo de dato incorrecto)
     * - JSON mal formado
     *
     * Versión simplificada sin Jackson
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(
            HttpMessageNotReadableException e) {

        // Mensaje simple y claro
        String message = "Datos inválidos en el request. Verifica el formato JSON y los valores de enum.";

        // Si quieres ser más específico, puedes analizar el mensaje de la excepción
        String exceptionMessage = e.getMessage();
        if (exceptionMessage != null && exceptionMessage.contains("enum")) {
            message = "Valor de enum inválido. Verifica que el valor sea uno de los permitidos (ACTION, DRAMA, COMEDY, HORROR, SCI_FI, THRILLER).";
        }

        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),    // 400
                message,
                "INVALID_FORMAT"
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    /**
     * Fallback para cualquier otra Exception no prevista
     * Retorna: 500 Internal Server Error
     * Cuando: Ocurre algo inesperado
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),  // 500
                "Error interno del servidor",
                "INTERNAL_SERVER_ERROR"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
}