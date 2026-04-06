package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_2;

public class MainWeb {
    public static void main(String[] args) {
        ServicioWeb servicio = new ServicioWeb();

        try {
            servicio.conectar(); // Puede lanzar ConnectionLostException
            servicio.procesarDatos();
        } catch (ConnectionLostException e){
            // Captura el fallo de conexión (Error de red)
            System.out.println("\n*** ERROR: Problema de red. ***");
            System.out.println("Detalles: " + e.getMessage());
        } catch (IllegalArgumentException e){
            // Captura el fallo de estado (Error de programación)
            System.out.println("\n*** ERROR: Error de lógica interna. ***");
            System.out.println("Detalles: " + e.getMessage());

        } catch (Exception e) {
            // Captura cualquier otro error
            System.out.println("ERROR INESPERADO: " + e.getMessage());
        } finally {
            servicio.cerrarConexion();
            System.out.println("\n--- FIN DE LA TRANSACCIÓN ---");
        }
    }

}
