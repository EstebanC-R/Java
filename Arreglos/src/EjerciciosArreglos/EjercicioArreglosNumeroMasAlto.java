package EjerciciosArreglos;

/* #
    Imprima el número más alto del arreglo

    Escriba un programa que imprima el
    número más alto de un arreglo de 7 elementos (de rango 11 a 99),
    por ejemplo {14, 33, 15, 36, 78, 21, 43}, si se repite un valor
    considerar uno solo.
*/

import java.util.Scanner;

public class EjercicioArreglosNumeroMasAlto {
    public static void main(String[] args) {

        int[] a = new int[7];
        Scanner rl = new Scanner(System.in);

        for(int i = 0; i < a.length; i++){
            System.out.print("Por favor Ingrese un número dentro del rango 11 - 99: ");

            validarNumero(rl);
            a[i] = rl.nextInt();
            validarRango(rl, a, i);
        }

        int max = 0;

        for(int i = 0; i < a.length; i++){
            max = max < a[i] ? a[i] : max;
        }

        System.out.println("El número mayor es: " + max);


    }

    public static void validarNumero(Scanner rl){
        while (!rl.hasNextInt()){
            System.out.print("Por favor coloque un número valido: ");
            rl.next();
        }
    }

    public static void validarRango(Scanner rl, int[] a, int i){
        while (a[i] < 11 || a[i] > 99){
            System.out.print("Por favor coloque un rango valido(11 - 99): ");

            validarNumero(rl);

            a[i] = rl.nextInt();
        }
    }
}
