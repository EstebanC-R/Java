package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_4;

// Una excepción no verificada se usa típicamente para fallas de lógica de programación (bugs).
public class ArgumentoNuloException extends RuntimeException {
    // Si quieres lanzar una exception
    public ArgumentoNuloException() {
        super();
    }
    // Si necesitas explicar qué objeto era nulo.
    public ArgumentoNuloException(String mensaje){
        super(mensaje);
    }
}
