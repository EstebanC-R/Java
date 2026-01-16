package EjerciciosMatrices;

import java.util.Scanner;

public class EjercicioMatrizX {
    public static void main(String[] args) {


        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del cuadro para dibujar la X.");

        System.out.print("Numero de Filas: ");
        int filas = rl.nextInt();

        System.out.print("Número de Columnas: ");
        int columnas = rl.nextInt();

        String[][] a = new String[filas][columnas];


        if((filas == columnas) && (filas > 2 && columnas > 2)){
            for(int i = 0; i < a.length; i++){
                for(int x = 0; x < a[i].length; x++){
                    if(i == x || i + x == a.length - 1){
                        a[i][x] = "X";
                    }else{
                        a[i][x] = "_";
                    }
                }
            }

            System.out.println("\n ---------------- Matriz ----------------");
            for(int i = 0; i < a.length; i++){
                for(int x = 0; x < a[i].length; x++){
                    System.out.printf(" %-5s ", a[i][x]);
                }
                System.out.println();
            }
        }else{
            System.out.println("\nIngrese datos validos por favor.");
            System.exit(-1);
        }
    }
}
