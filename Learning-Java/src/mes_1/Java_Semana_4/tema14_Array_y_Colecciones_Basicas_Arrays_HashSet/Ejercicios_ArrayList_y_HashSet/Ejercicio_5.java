package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet;

import java.util.HashSet;

public class Ejercicio_5 {
    public static void main(String[] args){
        HashSet<String> frutas = new HashSet<>();

        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Uva");
        frutas.add("Manzana");
        frutas.add("Pera");

        // Aunque le hallamos metido 5 datos, HashSet tiene la peculiaridad de que no permite o no cuenta
        // los repetidos, por lo que solo está contando 1 manzana y 1 pera.

        System.out.println("\nEl tamaño de la lista es: " + frutas.size());
        System.out.println("\n" + frutas);

        System.out.println(frutas.contains("Sandía")); // false
        System.out.println(frutas.contains("Uva")); // true
        frutas.remove("Pera");

        System.out.println("\nLista : " + frutas);
    }
}
