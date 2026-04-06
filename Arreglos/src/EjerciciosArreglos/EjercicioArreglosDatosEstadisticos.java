package EjerciciosArreglos;

/* #
    Sistema estadístico con elementos de un arreglo.

    Leer 7 números por teclado para llenar un arreglo
    y a continuación calcular el promedio de los números
    positivos, el promedio de los negativos y contar el
    número de ceros.
*/

import java.util.Scanner;

public class EjercicioArreglosDatosEstadisticos {
    public static void main(String[] args) {

        int[] a = new int[7];
        Scanner rl = new Scanner(System.in);
        int TotalesNegativos = 0, TotalesPositivos = 0, TotalesCero = 0, SumPosi = 0, SumNegat = 0;

        System.out.println("\nIngrese números negativos, positivos o iguales a o: ");
        for(int i = 0; i < a.length; i++){
            System.out.print("- ");
            a[i] = rl.nextInt();
        }
        System.out.println();

        for(int i = 0; i < a.length; i++){
            if(a[i] < 0){
                TotalesNegativos++;
                SumNegat  += a[i];
            }

            if(a[i] == 0){
                TotalesCero++;
            }

            if(a[i] > 0) {
                TotalesPositivos++;
                SumPosi += a[i];
            }
        }

        double promPosi = (double) SumPosi / TotalesPositivos;
        double promNegat = (double) SumNegat / TotalesNegativos;


        if(Double.isNaN(promPosi)){
            System.out.printf("- Promedio %-20s : %s\n", "Positivos", "No se ingreso ningún valor.");
        } else {
            System.out.printf("- Promedio %-20s : %.2f\n", "Positivos", promPosi);
        }

        if(Double.isNaN(promNegat)){
            System.out.printf("- Promedio %-20s : %s\n", "Negativos", "No se ingreso ningún valor.");
        } else {
            System.out.printf("- Promedio %-20s : %.2f\n", "Negativos", promNegat);
        }


        System.out.printf("- Recuento de %-20s : %d\n", "Ceros", TotalesCero);

    }
}
