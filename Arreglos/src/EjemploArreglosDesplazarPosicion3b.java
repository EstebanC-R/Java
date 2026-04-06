/* $
     Este programa recibe números ordenados.
     Luego pide un nuevo número y lo inserta en la posición correcta.
     Para no perder datos, crea un arreglo más grande
     y mantiene todos los valores ordenados.
*/

import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion3b {
    public static void main(String[] args) {

        int[] a = new int[7];
        // * Arreglo original

        int numero, posicion, ultimo;
        // * numero: valor a insertar
        // * posicion: lugar correcto según el orden
        // * ultimo: guarda el último valor del arreglo

        Scanner rl = new Scanner(System.in);

        // $ ---- LLENAMOS EL ARREGLO ----
        for(int i = 0; i < a.length; i++){
            System.out.print("Ingrese un número: ");
            a[i] = rl.nextInt();
        }

        System.out.println();

        // $ ---- NUEVO NÚMERO ----
        System.out.println("Ingrese un número a insertar: ");
        numero = rl.nextInt();

        // * Guardamos el último elemento
        ultimo = a[a.length - 1];

        // * Buscamos la posición correcta
        posicion = 0;
        while (posicion < 6 && numero > a[posicion]){
            posicion++;
        }

        // $ ---- DESPLAZAMOS ----
        for(int i = a.length - 2; i >= posicion; i--){
            a[i+1] = a[i];
        }

        // $ ---- NUEVO ARREGLO MÁS GRANDE ----
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, a.length);

        // $ ---- INSERTAMOS CORRECTAMENTE ----
        if(numero > ultimo){
            // * Si el número es mayor que todos, va al final
            b[b.length - 1] = numero;
        } else {
            // * Si va en medio, acomodamos todo
            b[b.length - 1] = ultimo;
            b[posicion] = numero;
        }

        //  $ ---- MOSTRAMOS EL RESULTADO ----
        System.out.println("El nuevo arreglo ordenado es: ");
        for(int i = 0; i < b.length; i++){
            System.out.println(i + " => " + b[i]);
        }
    }
}
