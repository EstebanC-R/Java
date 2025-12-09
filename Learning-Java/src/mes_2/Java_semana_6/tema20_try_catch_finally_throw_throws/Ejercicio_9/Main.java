package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_9;

public class Main {
    public static void validar(int n) throws Exception{
        System.out.println("Intentando validar el número: " + n);
        if(n < 0){
            throw new Exception("ERROR: El número "+n+" es negativo y no es permitido.");
        }
        System.out.println("-> Validación exitosa: El número es válido.");
    }

    public static void main(String[] args) {
        int numeroValido = 10;

        int numeroInvalido = -5;

        System.out.println("\n------------------ INICIO DEL PROGRAMA ---------------");

        try{
            validar(numeroValido);
        }catch (Exception e){
            System.out.println("ERROR CAPTURANDO (Validación 1): " + e.getMessage());
        }

        System.out.println("\n----------------------------------------------");


        try{
            validar(numeroInvalido);
            System.out.println("Esta línea NO aparecerá si el número falla.");
        } catch (Exception e){
            System.out.println("\n*** EXCEPCIÓN CAPTURADA EN MAIN ***");
            System.out.println("Mensaje de error: " + e.getMessage());
        }

        System.out.println("\n--- FIN DEL PROGRAMA (El programa continuó sin caerse) ---");
    }
}
