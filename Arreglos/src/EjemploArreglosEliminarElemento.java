/* $
     Este programa guarda 10 números en un arreglo.
     Luego el usuario elige una posición para eliminar.
     El programa mueve los números para tapar ese espacio
     y crea un nuevo arreglo más pequeño sin el elemento eliminado.
*/

import java.util.Scanner;

public class EjemploArreglosEliminarElemento {
    public static void main(String[] args) {

        int[] a = new int[10];
        // * Arreglo original con 10 números

        Scanner rl = new Scanner(System.in);
        // * Scanner para leer números del teclado

        // $ ---- LLENAMOS EL ARREGLO ----
        for(int i = 0; i < a.length; i++){
            System.out.print("Ingrese un número: ");
            a[i] = rl.nextInt();
        }

        System.out.println();

        // $ ---- PEDIMOS LA POSICIÓN A ELIMINAR ----
        System.out.println("Ingrese una posición a eliminar entre 0 y 9: ");
        int posicion = rl.nextInt();

        // $ ---- DESPLAZAMOS LOS ELEMENTOS A LA IZQUIERDA ----
        for(int i = posicion; i < a.length - 1; i++){
            // * Desde la posición eliminada hasta el final

            a[i] = a[i+1];
            // * Copiamos el valor siguiente sobre el actual
            // * Esto "borra" el número elegido
        }

        /* ! for(int i = 0; i < a.length - 1; i++){
            System.out.println(i + " => " + a[i]);
        } */

        // $ ---- CREAMOS UN NUEVO ARREGLO MÁS PEQUEÑO ----
        int[] b = new int[a.length - 1];
        // * Nuevo arreglo con una posición menos

        System.arraycopy(a, 0, b, 0, b.length);
        // * Copiamos los elementos del arreglo 'a' al nuevo arreglo 'b'

        // $ ---- MOSTRAMOS EL ARREGLO FINAL ----
        for(int i = 0; i < b.length; i++){
            System.out.println(i + " => " + b[i]);
        }
    }
}
