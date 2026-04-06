package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_3;

public class DatosInvalidosException extends Exception{

    // Una excepción verificada se usa típicamente para errores anticipables de los que el programa puede recuperarse.
    public DatosInvalidosException(String mensaje){
        super(mensaje);
    }

}
