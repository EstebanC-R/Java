package Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ejercicio_1 {
    public static void main(String[] args){
        int[] numeros = new int[10];

        for(int i = 0; i < 10; i++){
            numeros[i] = i + 1;
            System.out.println("Posición " + i + " valor = " + numeros[i]);
        }
        System.out.println("\nLista = \n" + Arrays.toString(numeros));
        System.out.println();

        int suma = 0;
        for(int n : numeros){
            suma += n;
            System.out.println((suma - n) + " + " + n + " = " + suma);
        }

        System.out.println("\nLa suma entera sería : " + suma);

        int mayor = 0;

        for(int i = 0; i < numeros.length; i++){
            if(mayor < numeros[i]){
                mayor = numeros[i];
            }
        }

        System.out.println("\nEl mayor es: " + mayor);

        int menor = numeros[0];

        for(int i = 0; i < numeros.length ; i++){
            if(numeros[i] < menor){
                menor = numeros[i];
            }
        }

        System.out.println("El número menor es: " + menor);

        int[] invertir = new int[numeros.length];

        for(int i = 0; i < numeros.length; i++){
            invertir[i] = numeros[numeros.length - 1 - i];
            // Es un poco enredado, pero a la final solo hay que pensar
            // numeros[valor] el valor significa una posición en la lista
            // por lo que si se resuelve lo de adentro, se nota que se inicia en la última
            // posición, hasta llegar a la posición inicial de la original que es 0.
        }

        System.out.println("\n" + Arrays.toString(invertir));
    }
}
