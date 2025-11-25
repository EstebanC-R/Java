package mes_2.Java_semana_6.try_catch_finally_throw_throws.Ejercicio_5;

public class Main {
    public static void main(String[] args) {
        try{
            abrirConexion();
        }finally {
            cerrarConexion();
        }
    }

    public static void abrirConexion(){
        System.out.println("Conexion abierta");
    }

    public static void cerrarConexion(){
        System.out.println("Conexion cerrada");
    }
}
