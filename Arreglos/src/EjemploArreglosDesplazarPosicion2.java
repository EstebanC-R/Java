/* $
    Este programa guarda números en un arreglo.
    Luego le pide al usuario un nuevo número y la posición donde quiere colocarlo.
    Para poder insertarlo, mueve los números hacia la derecha desde esa posición.
    Al final muestra el arreglo con el nuevo número ya insertado.
*/

import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2 {
    public static void main(String[] args) {

        int[] num = new int[10];
        // * Arreglo con espacio para 10 números

        int elemento, posicion;
        // * 'elemento' guarda el nuevo número
        // * 'posicion' indica en qué lugar se va a insertar

        Scanner rl = new Scanner(System.in);
        // * Scanner para leer datos del teclado

        // $ ---- LLENAMOS EL ARREGLO (9 POSICIONES) ----
        for(int i = 0; i < num.length - 1; i++){
            // * Solo llenamos hasta la posición 8
            // * Dejamos una posición libre para el nuevo número

            System.out.println("Ingrese el número: ");
            num[i] = rl.nextInt();
        }

        System.out.println();

        // $ ---- PEDIMOS EL NUEVO ELEMENTO ----
        System.out.println("Nuevo elemento: ");
        elemento = rl.nextInt();

        // $ ---- PEDIMOS LA POSICIÓN ----
        System.out.println("Posición donde agregar (0 - 9): ");
        posicion = rl.nextInt();

        // $ ---- DESPLAZAMOS LOS ELEMENTOS A LA DERECHA ----
        for(int i = num.length - 2; i >= posicion; i-- ){
            // * Empezamos desde la última posición con valor
            // * y nos movemos hacia atrás hasta la posición indicada

            num[i + 1] = num[i];
            // * Movemos cada número una posición a la derecha
        }

        // $ ---- INSERTAMOS EL NUEVO ELEMENTO ----
        num[posicion] = elemento;
        // * Colocamos el nuevo número en la posición elegida

        // $ ---- MOSTRAMOS EL ARREGLO FINAL ----
        System.out.println("El arreglo: ");
        for(int i = 0; i < num.length; i++){
            System.out.println(num[i]);
        }
    }
}
