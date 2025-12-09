package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_7;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        try {
            cuenta.transferir(100.0, "Cuenta Destino");
        } catch (DatosInvalidosException2 e) {

            System.err.println("--- ERROR DE NEGOCIO ---");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Campo afectado: " + e.getNombreCampo()); // Uso del campo enriquecido

            // Acceder a la causa original:
            if (e.getCause() != null) {
                System.err.println("\n--- CAUSA RAÍZ TÉCNICA ---");
                System.err.println("Tipo: " + e.getCause().getClass().getSimpleName());
                System.err.println("Detalle: " + e.getCause().getMessage());
            }
        }
    }
}
