package mes_2.Java_semana_6.try_catch_finally_throw_throws.Ejercicio_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        int divisor = 0;
        System.out.println("Ingrese un número entero: ");

        try{
            String numTexto = rl.nextLine();
            divisor = Integer.parseInt(numTexto);

            double resultado = 100 / (double) divisor;
            System.out.println("El resultado de (100 / " + divisor + ") es igual a = " + resultado);
        }catch (NumberFormatException e){
            System.out.println("Error de formato: Ingrese un **número entero válido**.");
            System.out.println("Detalle: " + e.getMessage());
        }catch (ArithmeticException e){
            System.out.println("Error matemático: No se puede **dividir por cero**");
        }finally {
            rl.close();
            System.out.println("\n--- Fin del ejercicio 3 ---");
        }
    }
}
