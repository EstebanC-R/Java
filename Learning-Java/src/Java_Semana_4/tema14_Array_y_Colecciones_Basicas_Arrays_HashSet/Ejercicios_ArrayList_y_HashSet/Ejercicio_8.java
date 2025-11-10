package Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet;

import java.util.ArrayList;
import java.util.HashSet;

public class Ejercicio_8 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        HashSet<String> nombres2 = new HashSet<>();

        nombres.add("Milton");
        nombres.add("Yony");
        nombres.add("Mateo");
        nombres.add("Milton");
        nombres.add("Yony");

        nombres2.add("Yeison");
        nombres2.add("Daniel");
        nombres2.add("Ember");
        nombres2.add("Yeison");
        nombres2.add("Daniel");

        System.out.println("\n\n---- Lista ArrayList ----");
        System.out.println("Este permite duplicados, también mantiene el orden de inserción, también permite traer el índice con .get(índice).\n");
        System.out.println(nombres);
        System.out.println("- Índice 1: " + nombres.get(1));
        System.out.println("\n\n---- Lista HashSet -----");
        System.out.println("Este NO permite duplicados NI mantiene el orden de inserción NI permite obtener el índice.\n");
        System.out.println(nombres2);
    }
}
