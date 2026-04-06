package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese un texto a convertir en número.");

        try{
            String respuesta = rl.nextLine();
            int convertirRespuesta = Integer.parseInt(respuesta);
            System.out.println(convertirRespuesta);
        }catch (NumberFormatException e){
            System.out.println("ERROR. Formato no valido " + e.getMessage());
        }finally {
            System.out.println("Finalizando operación.");
        }
    }
}
