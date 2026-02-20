package co.esteba.pruebas.nivel1.exceptions;

public class EmpleadoDuplicadoException extends RuntimeException {
    public EmpleadoDuplicadoException(String message) {
        super(message);
    }
}
