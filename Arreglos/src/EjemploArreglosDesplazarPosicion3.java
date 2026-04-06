/* $
     Este programa recibe números ordenados de menor a mayor.
     Luego pide un nuevo número y busca automáticamente
     la posición correcta para mantener el orden.
     Después mueve los números y coloca el nuevo valor.
*/

import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion3 {
    public static void main(String[] args) {

        int[] a = new int[7];
        // * Arreglo para números ordenados

        int numero, posicion;
        // * numero: nuevo valor a insertar
        // * posicion: lugar donde debe ir para mantener el orden

        Scanner rl = new Scanner(System.in);

        // $ ---- LLENAMOS EL ARREGLO (6 VALORES) ----
        for(int i = 0; i < a.length - 1; i++){
            System.out.print("Ingrese un número: ");
            a[i] = rl.nextInt();
        }

        System.out.println();

        // $ ---- NUEVO NÚMERO ----
        System.out.println("Ingrese un número a insertar: ");
        numero = rl.nextInt();

        // * Buscamos la posición correcta
        posicion = 0;
        while (posicion < 6 && numero > a[posicion]){
            posicion++;
        }

        // $ ---- DESPLAZAMOS LOS ELEMENTOS ----
        for(int i = a.length - 2; i >= posicion; i--){
            a[i+1] = a[i];
        }

        // * Insertamos el número
        a[posicion] = numero;

        // $ ---- MOSTRAMOS EL ARREGLO ----
        System.out.println("El nuevo arreglo ordenado es: ");
        for(int i = 0; i < a.length; i++){
            System.out.println(i + " => " + a[i]);
        }
    }
}
