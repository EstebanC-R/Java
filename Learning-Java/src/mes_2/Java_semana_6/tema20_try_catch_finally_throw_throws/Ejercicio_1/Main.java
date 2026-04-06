package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);

        System.out.println("Por favor ingrese el primer número: ");
        int a = rl.nextInt();

        System.out.println("Por favor ingrese el segundo número: ");
        int b = rl.nextInt();

        int resultado = suma(a, b);

        System.out.println("El resultado es: "+ resultado);
    }

    public static int suma(int a, int b){
        int x = 0;

        try{
            x = a / b;
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir entre cero.");
        }
        return x;
    }
}
