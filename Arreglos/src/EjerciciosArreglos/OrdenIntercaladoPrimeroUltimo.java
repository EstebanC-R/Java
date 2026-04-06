package EjerciciosArreglos;

/* $
    Leer 10 números enteros desde el teclado para llenar un
    arreglo de 10 elementos. Luego debemos mostrarlos en el
    siguiente orden: el último, el primero, el penúltimo,
    el segundo, el antepenúltimo, el tercero, y así sucesivamente.
*/

import java.util.Scanner;

public class OrdenIntercaladoPrimeroUltimo {
    public static void main(String[] args) {

        int[] a = new int[10];
        Scanner rl = new Scanner(System.in);

        for(int i = 0; i < a.length; i++){
            System.out.print("Ingrese un número: ");
            a[i] = rl.nextInt();
        }

        System.out.println();

        for(int i = 0; i < a.length / 2; i++){
            System.out.println(" => " + a[a.length - 1 - i]);
            System.out.println(" => " + a[i]);
        }
    }
}
