package EjerciciosMatrices;

import java.util.Scanner;

public class EjercicioMatrizSilla {
    public static void main(String[] args) {

        Scanner rl = new Scanner(System.in);
        System.out.println("Por favor indique las dimensiones n1 * n2 (filas y columnas)");
        System.out.print("- Filas: ");
        int filas = rl.nextInt();

        System.out.print("- Columnas: ");
        int columnas = rl.nextInt();

        int[][] a = new int[filas][columnas];

        if(filas > 2 && columnas >= 3){
            for(int i = 0; i < a.length; i++){
                for(int x = 0; x < a[i].length; x++){
                    if(x == 0 || i == filas/2 || (x == columnas - 1 && i >= filas/2)){
                        a[i][x] = 1;
                    }
                }
            }

            for(int i = 0; i < a.length; i++){
                for(int x = 0; x < a[i].length; x++){
                    System.out.printf(" %-5d ", a[i][x]);
                }
                System.out.println();
            }
        }else{
            System.out.println("\nERROR");
            System.exit(-1);
        }
    }
}
