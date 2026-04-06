package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet;

import java.util.ArrayList;

public class Ejercicio_3 {
    public static void main(String[] args){
        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Milton");
        nombres.add("Yony");
        nombres.add("Yeison");
        nombres.add("Mateo");
        nombres.add("Daniel");

        System.out.println();
        for(String nom : nombres){
            System.out.println(nom);
        }



        System.out.println("\nEl largo de la lista es: " + nombres.size());

        nombres.remove(1);

        System.out.println("\n"+nombres);

        boolean encontrar = nombres.contains("Yony");
        boolean encontrar2 = nombres.contains("Mateo");

        System.out.printf("\nBúsqueda : %s\n%s : %s\n",
                encontrar,
                "Búsqueda", encontrar2
                );


        nombres.add(0, "Esteban");

        System.out.println("\n"+ nombres + "\n");

        nombres.clear();

        System.out.println(nombres);

        boolean llena = nombres.isEmpty();

        System.out.println("\nLa lista esta vacía?: " + llena);
    }
}
