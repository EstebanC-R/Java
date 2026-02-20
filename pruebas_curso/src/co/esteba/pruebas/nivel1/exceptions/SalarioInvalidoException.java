package co.esteba.pruebas.nivel1.exceptions;

public class SalarioInvalidoException extends RuntimeException {
    public SalarioInvalidoException(String message) {
        super(message);
    }
}
