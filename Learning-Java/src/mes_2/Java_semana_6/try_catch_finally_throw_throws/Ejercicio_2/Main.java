package mes_2.Java_semana_6.try_catch_finally_throw_throws.Ejercicio_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese un número: ");

        try{
            String numText = rl.nextLine();
            int num = Integer.parseInt(numText);
            System.out.println("El número es: " + num);
        }catch (NumberFormatException e){
            System.out.println("No haz ingresado un número.");
        }
    }
}
