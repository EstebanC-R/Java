package Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class Ejercicio_6 {
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(5);
        numeros.add(2);
        numeros.add(8);
        numeros.add(2);
        numeros.add(9);
        numeros.add(5);
        numeros.add(3);
        numeros.add(8);
        numeros.add(1);
        numeros.add(5);

        System.out.println("\n\nNúmeros con duplicados: " + numeros);

        HashSet<Integer> copiaSinDuplicados = new HashSet<Integer>(numeros);

        System.out.println("\n\nHashSet sin duplicados: " + copiaSinDuplicados);

        ArrayList<Integer> copiaDelHashSetSinDuplicados = new ArrayList<Integer>(copiaSinDuplicados);

        System.out.println("\nLista sin duplicados: " + copiaDelHashSetSinDuplicados);
    }
}
