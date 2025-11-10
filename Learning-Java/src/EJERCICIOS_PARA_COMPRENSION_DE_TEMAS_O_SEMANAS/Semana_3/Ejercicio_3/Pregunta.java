package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_3;

import java.util.Scanner;

public class Pregunta {
    public static void pregunta(Scanner rl){
        System.out.println("\nQuieres escoger otra opción?");
        System.out.println("1. si.");
        System.out.println("2. no.");
        System.out.println("Escoge 1 o 2: ");
        if(rl.hasNextInt()){
            int respuesta = rl.nextInt();
            if(respuesta == 1){
                Menu.menu();
            } else if (respuesta == 2) {
                System.out.println("Gracias por utilizar nuestro sistema :) :P (^_^) :3");
                rl.close();
            } else {
                System.out.println("Escoge un número valido.");
                pregunta(rl);
            }
        }
    }
}
