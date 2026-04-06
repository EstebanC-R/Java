package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_3;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Utilidades {

    //----------------------Encontrar Maximo------------------------------
    static int[] encontrarMaximo(Scanner rl){
        System.out.println("Cuantos números vas a ingresar?: ");

        if(rl.hasNextInt()){
            int cantidad = rl.nextInt();
            int[] numeros = new int[cantidad];

            for(int i = 0; i < cantidad; i++){
                System.out.println("Coloque su " + (i + 1) + " valor de la lista.");
                while (!rl.hasNextInt()){
                    System.out.println("Ingrese un valor valido para el valor " + (i + 1) + ": ");
                    rl.next();
                }
                numeros[i] = rl.nextInt();
            }
            return numeros;
        }else{
            System.out.println("Entrada invalida, ingresa un número.");
            rl.next();
            return encontrarMaximo(rl);
        }
    }

    static int calcularMaximo(int[] numeros){
        int max = numeros[0];
        for(int n : numeros){
            if(n > max) max = n;
        }
        return max;
    }

    //----------------------Encontrar Minimo------------------------------

    static int[] encontrarMinimo(Scanner rl){
        System.out.println("Cuantos números vas a ingresar?: ");

        if(rl.hasNextInt()){
            int cantidad = rl.nextInt();
            int[] numeros = new int[cantidad];

            for(int i = 0; i < cantidad; i++){
                System.out.println("Ingrese el valor del número " + (i + 1) + ": ");
                while(!rl.hasNextInt()){
                    System.out.println("Ingrese un valor valido para el valor " + (i + 1) + ": ");
                    rl.next();
                }
                numeros[i] = rl.nextInt();
            }
            return numeros;
        }else{
            System.out.println("Entrada invalida, ingresa un número.");
            rl.next();
            return encontrarMaximo(rl);
        }
    }

    static int calcularMinimo(int[] numeros){
        int minim = numeros[0];
        for(int n : numeros){
            if(n < minim) minim = n;
        }
        return minim;
    }

    //---------------------- Calcular promedio ------------------------------

    static int[] encontrarPromedio(Scanner rl){
        System.out.println("Cuantos datos quieres ingresar?: ");

        while(!rl.hasNextInt()){
            System.out.println("Ingrese un número valido: ");
            rl.next();
        }
        int cantidadDeDatos = rl.nextInt();
        int[] numeros = new int[cantidadDeDatos];

        for(int i = 0; i < cantidadDeDatos; i++){
            System.out.println("Ingrese el valor del número " + (i + 1) + ": ");
            while (!rl.hasNextInt()){
                System.out.println("Ingrese un valor valido para la posición en lista " + (i + 1) + ": ");
                rl.next();
            }
            numeros[i] = rl.nextInt();
        }
        return numeros;
    }


    static double calcularPromedio(int[] numeros){
        int numeroDeDatos = numeros.length;
        int sumaDeDatos = 0;

        for(int n : numeros){
            sumaDeDatos += n;
        }

        return (double) sumaDeDatos / numeroDeDatos;
    }

    //---------------------- Es primo? ------------------------------

    static int ingresarPrimo(Scanner rl){
        System.out.println("Ingresa el número que quieres investigar: ");
        while (!rl.hasNextInt()){
            System.out.println("Ingrese un número valido, (Entero y sin Texto): ");
            rl.next();
        }

        int num = rl.nextInt();

        return num;
    }

    static boolean esPrimo(int numero){
        if(numero % 2 == 0){
            System.out.println("El número " + numero + ". Si es primo");
            return true;
        }else{
            System.out.println("No, este número no es primo: "+ numero);
            return false;
        }
    }

    //---------------------- Es invertir cadena ------------------------------

    static String ingresarCadena(Scanner rl){
        rl.nextLine();
        System.out.println("Ingrese el texto o palabra que quiera invertir: ");

        String dataTexto = rl.nextLine();

        return dataTexto;
    }


    // charAt es para acceder al contenido de la iteración.
    static String invertirCadena(String texto){
        String cadena = "";

        for(int i = texto.length() -1; i >= 0 ;  i--){
            cadena += texto.charAt(i);
        }

        return cadena;
    }
}
