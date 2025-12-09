package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_7;

public class DatosInvalidosException2 extends Exception{
    private String nombreCampo;

    // Una excepción verificada se usa típicamente para errores anticipables de los que el programa puede recuperarse.
    public DatosInvalidosException2(String mensaje, String campo){
        super(mensaje);
        this.nombreCampo = campo;
    }

    public DatosInvalidosException2(String mensaje, String campo, Throwable cause){
        super(mensaje, cause);
        this.nombreCampo = campo;
    }

    public String getNombreCampo(){
        return nombreCampo;
    }

}
