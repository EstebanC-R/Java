package EjerciciosArreglos;

/* #
    Obtener el elemento con mas ocurrencia en el arreglo.

    Para la tarea se debe crear un arreglo con 10 elementos
    (enteros en el rango de 1 a 9). Escriba un programa que
    imprima el número que tiene más ocurrencias en el arreglo
    y también imprimir la cantidad de veces que aparece en el arreglo.

    Por ejemplo, para el arreglo: {1, 2, 3, 3, 4, 5, 5, 5, 6, 7}
    Como resultado debería imprimir lo siguiente:

        - La mayor ocurrencias es: 3
        - El elemento que mas se repite es: 5

    En el ejemplo, el elemento que más se repite en el arreglo es el
    número 5 con una ocurrencia de 3 veces.
*/

import java.util.Scanner;

public class EjercicioArreglosMayorOcurrencia {
    public static void main(String[] args) {


        int[] a = new int[10];
        Scanner rl = new Scanner(System.in);

        for(int i = 0; i < a.length; i++){
            System.out.println("Ingrese un número: ");
            validarNumero(rl);
            a[i] = rl.nextInt();
            validarRango(rl, a, i);
        }

        int maxOcurrencias = 0;
        int elementoMasRepetido = 0;


        for(int i = 0; i < a.length; i++){
            int contador = 0; // * a[i] repeticiones

            for(int j = 0; j < a.length; j++){
                if(a[i] == a[j]){
                    contador++;
                }
            }

            if(contador > maxOcurrencias){
                maxOcurrencias = contador;
                elementoMasRepetido = a[i];
            }
        }

        System.out.println("La mayor ocurrencia es: " + maxOcurrencias);
        System.out.println("El elemento que más se repite es: " + elementoMasRepetido);
    }

    public static void validarNumero(Scanner rl){
        while (!rl.hasNextInt()){
            System.out.print("Por favor coloque un número valido: ");
            rl.next();
        }
    }

    public static void validarRango(Scanner rl, int[] a, int i){
        while (a[i] < 1 || a[i] > 9){
            System.out.print("Por favor coloque un rango valido(11 - 99): ");

            validarNumero(rl);

            a[i] = rl.nextInt();
        }
    }
}
