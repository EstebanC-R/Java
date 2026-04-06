/* $
     Este programa guarda 10 números en un arreglo.
     Luego pide un nuevo número y la posición donde se quiere insertar.
     Para hacer espacio, desplaza los números hacia la derecha.
     Después crea un nuevo arreglo más grande y guarda ahí todos los valores,
     incluyendo el nuevo número en la posición indicada.
*/

import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion2b {
    public static void main(String[] args) {

        int[] a = new int[10];
        // * Arreglo original

        int elemento, posicion, ultimo;
        // * elemento: nuevo número a insertar
        // * posicion: lugar donde se insertará
        // * ultimo: guarda el último número del arreglo

        Scanner rl = new Scanner(System.in);

        // $ ---- LLENAMOS EL ARREGLO ----
        for(int i = 0; i < a.length; i++){
            System.out.print("Ingrese el número: ");
            a[i] = rl.nextInt();
        }

        System.out.println();

        // $ ---- PEDIMOS EL NUEVO ELEMENTO ----
        System.out.println("Nuevo elemento: ");
        elemento = rl.nextInt();

        // $ ---- PEDIMOS LA POSICIÓN ----
        System.out.println("Posición donde agregar (0 - 9): ");
        posicion = rl.nextInt();

        // * Guardamos el último elemento del arreglo
        ultimo = a[a.length - 1];

        // $ ---- DESPLAZAMOS LOS ELEMENTOS ----
        for(int i = a.length - 2; i >= posicion; i-- ){
            a[i + 1] = a[i];
        }

        // $ ---- CREAMOS UN NUEVO ARREGLO MÁS GRANDE ----
        int[] b = new int[a.length + 1];
        // * Ahora el arreglo tiene una posición extra

        System.arraycopy(a, 0, b, 0, a.length);
        // * Copiamos todos los valores de 'a' a 'b'

        // * Insertamos el nuevo elemento
        b[posicion] = elemento;

        // * Colocamos el último valor al final
        b[b.length - 1] = ultimo;

        // $ ---- MOSTRAMOS EL RESULTADO ----
        System.out.println("El arreglo: ");
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
    }
}
