package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_2;

public class ServicioWeb {
    private boolean conectado = false;
    private final String URL = "api.serviciodedatos.com";

    public void conectar() {
        System.out.println("Intentado conectar a " + URL + "...");

        if((Math.random() * 5) > 2){
            throw new ConnectionLostException(URL);
        }

        this.conectado = true;
        System.out.println("Conexión exitosa.");
    }

    public void procesarDatos(){

        if(!conectado){
            throw new IllegalStateException("Debe estar conectado para procesar datos.");
        }
        System.out.println("Datos procesados correctamente.");
    }

    public void cerrarConexion(){
        if(conectado) {
            this.conectado = false;
            System.out.println("Conexión con " + URL + " cerrada de forma segura.");
        } else {
            System.out.println("No había conexión activa que cerrar.");
        }
    }
}
