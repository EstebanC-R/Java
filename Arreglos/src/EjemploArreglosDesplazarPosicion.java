/* $
     Este programa pide al usuario 6 números y los guarda en un arreglo.
     Luego toma el último número del arreglo y lo mueve a la primera posición,
     desplazando todos los demás números una posición hacia la derecha.
     Finalmente, muestra el arreglo ya modificado en pantalla.
*/

import java.util.Scanner;
// ! Importamos Scanner para poder leer datos que el usuario escriba por teclado

public class EjemploArreglosDesplazarPosicion {
    public static void main(String[] args) {

        int[] num = new int[6];
        // * Creamos un arreglo de enteros con 6 posiciones
        // * Ejemplo: [0, 0, 0, 0, 0, 0]

        int ultimo;
        // * Esta variable guardará el último valor del arreglo

        Scanner rl = new Scanner(System.in);
        // * Creamos el objeto Scanner para leer números desde el teclado

        // $ ---- LLENAR EL ARREGLO ----
        for(int i = 0; i < num.length; i++){
            // * El for recorre todas las posiciones del arreglo (0 a 5)

            System.out.println("Ingrese el número: ");
            // * Pedimos al usuario que ingrese un número

            num[i] = rl.nextInt();
            // * Guardamos el número ingresado en la posición i del arreglo
        }

        System.out.println();
        // * Solo imprime una línea en blanco para que se vea más ordenado

        // $ ---- GUARDAMOS EL ÚLTIMO ELEMENTO ----
        ultimo = num[num.length - 1];
        // * Guardamos el último valor del arreglo
        // * num.length - 1 es la última posición (5)
        // * Ejemplo: si el arreglo es [1,2,3,4,5,6] → ultimo = 6

        // $ ---- DESPLAZAMOS LOS ELEMENTOS A LA DERECHA ----
        for(int i = num.length - 2; i >= 0; i-- ){
            // * Empezamos desde la penúltima posición (4) = 5
            // * Vamos hacia atrás hasta llegar a la posición 0

            num[i + 1] = num[i];
            // * Copiamos el valor de la posición i a la posición siguiente
            // * Ejemplo: num[5] = num[4], num[4] = num[3], etc.
        }

        // $ ---- COLOCAMOS EL ÚLTIMO VALOR AL INICIO ----
        num[0] = ultimo;
        // * Ponemos el valor que estaba al final ahora en la primera posición

        // $ ---- MOSTRAMOS EL ARREGLO FINAL ----
        System.out.println("El arreglo: ");
        for(int i = 0; i < num.length; i++){
            // * Recorremos el arreglo nuevamente

            System.out.println(num[i]);
            // * Imprimimos cada valor del arreglo
        }
    }
}
