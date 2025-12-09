package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_2;

public class ConnectionLostException extends RuntimeException{
    public ConnectionLostException(String url){
        super("Fallo al establecer conexión con: " + url);
    }
}
