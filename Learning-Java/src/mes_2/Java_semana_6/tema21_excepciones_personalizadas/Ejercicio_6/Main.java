package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_6;

public class Main {
    public static void main(String[] args) {
        Procesador.procesarObjeto(null);

        // No te obliga a utilizar try-catch debido a que es una excepcion del tipo RuntimeException.

        // Como se a visto Exception es (Verificada / Checked) Se usa para errores que el programador
        // debe anticipar y manejar para que el programa se recupere (Ej. FileNotFoundException).

        // Por otro lado RuntimeException (No Verifica / Unchecked) El compilador NO OBLIGA a
        // manejarla. Se usa para errores que indican un defecto en la lógica de programación
        // que el desarrollador debería haber corregido antes de la ejecución (Ej. NullPointerException).
    }
}
