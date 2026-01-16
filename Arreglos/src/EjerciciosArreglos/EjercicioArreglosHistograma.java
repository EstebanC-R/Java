package EjerciciosArreglos;

/* #
    Escribir un programa que recorra un arreglo y genere un histograma en base a los valores de este.

    El arreglo debe contener 12 elementos que corresponden a números enteros de rango 1 al 6.

    Un histograma es una representación gráfica (de puntos o barra) de que tanto un elemento
    aparece en un conjunto de datos, es decir debe mostrar la frecuencia para todos los números
    del 1 al 6, incluso si no están presente en el arreglo.

    Por ejemplo para el arreglo {4, 3, 4, 6, 6, 4, 1, 4, 5, 4, 1, 1} el histograma debería ser:
        1: ***
        2:
        3: *
        4: *****
        5: *
        6: **
    Para la tarea usaremos el asterisco(*) como representación gráfica para el histograma.

*/

import java.util.Scanner;

public class EjercicioArreglosHistograma {
    public static void main(String[] args) {
        int[] a = new int[12];
        Scanner rl = new Scanner(System.in);

        int[] rango = new int[6];
        rango[0] = 1;
        rango[1] = 2;
        rango[2] = 3;
        rango[3] = 4;
        rango[4] = 5;
        rango[5] = 6;

        System.out.println("\nIngrese 12 números: ");
        for(int i = 0; i < a.length; i++){
            System.out.print("- ");
            validarNumero(rl);
            a[i] = rl.nextInt();
            validarRango(rl, a, i);
        }

        for(int i = 0; i <rango.length; i++){
            int contador = 0;

            for(int j = 0; j < a.length; j++){
                if(rango[i] == a[j]){
                    contador++;
                }
            }

            rango[i] = contador;
        }

        // ? METODO '.repeat()' es básicamente para repetir un número determinado de veces un carácter o cadena de texto.

        for(int i = 0; i < rango.length; i++){
            System.out.println((i + 1) + ": " + "*".repeat(rango[i]));
        }

    }

    public static void validarNumero(Scanner rl){
        while (!rl.hasNextInt()){
            System.out.print("Por favor coloque un número valido: ");
            rl.next();
        }
    }

    public static void validarRango(Scanner rl, int[] a, int i){
        while (a[i] < 1 || a[i] > 6){
            System.out.print("Por favor coloque un rango valido(1 - 6): ");

            validarNumero(rl);

            a[i] = rl.nextInt();
        }
    }
}
