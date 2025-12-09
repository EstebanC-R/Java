package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_11;

public class InfoCorreo {
    private static int contador = 1;
    private int ID;
    private String nombre;
    private int edad;
    private String correo;

    public InfoCorreo(String nombre, int edad, String correo){
        this.ID = contador++;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public String getCorreo(){
        return correo;
    }
}
