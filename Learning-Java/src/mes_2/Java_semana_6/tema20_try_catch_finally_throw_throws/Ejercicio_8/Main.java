package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_8;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void leerArchivo(String ruta) throws IOException{
        System.out.println("Intentando abrir el archivo en la ruta: " + ruta);
        FileReader lector = new FileReader(ruta);

        lector.close();
        System.out.println("Archivo abierto y cerrado correctamente!");
    }

    public static void main(String[] args) {
        String rutaInexistente = "C:\\Users\\GAFIME\\Downloads\\Bitacora_1.xlsx";

        System.out.println("\n------------ INICIO DEL PROGRAMA ---------------");

        try{
            leerArchivo(rutaInexistente);
            System.out.println("Esta línea NO aparecerá si el archivo falla.");
        }catch (IOException e){
            System.out.println("\n*** EXCEPCIÓN ATRAPADA EN MAIN ***");
            System.out.println("Mensaje de error: No se pudo acceder al archivo.");
            System.out.println("Detalles del sistema: " + e.getMessage());
        }

        System.out.println("\n--- FIN DEL PROGRAMA (El programa continuó sin caerse) ---");
    }
}
