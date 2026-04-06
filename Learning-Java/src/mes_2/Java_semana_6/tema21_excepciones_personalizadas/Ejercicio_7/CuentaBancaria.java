package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_7;

import java.io.IOException;

public class CuentaBancaria {
    public void transferir(double monto, String destino) throws DatosInvalidosException2{

        System.out.println("Iniciando Transferencia...");

        // Simulación: Error de I/O al intentar escribir un registro de la transacción.
        boolean errorDeLog = true;

        if(errorDeLog){
            try {
                // 1. Ocurre una excepción de bajo nivel (fuera de nuestro control directo)
                throw new IOException("El archivo de log de transacciones está bloqueado.");
            } catch (IOException e) {

                // 2. Capturamos la excepción de bajo nivel (e)
                String mensajeDeNegocio = "No se pudo completar la transferencia debido a un error de sistema interno.";
                String campoAfectado = "LOG_TRANSACCION";

                // 3. Lanzamos nuestra excepción de negocio,
                //    PASANDO 'e' (la IOException) como el tercer argumento ('cause').
                throw new DatosInvalidosException2(mensajeDeNegocio, campoAfectado, e);
            }
        }
    }
}
