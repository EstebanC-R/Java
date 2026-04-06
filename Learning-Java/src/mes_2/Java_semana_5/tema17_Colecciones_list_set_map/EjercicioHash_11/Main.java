package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioHash_11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(
                Arrays.asList(1,1,2,3,4,3,4,4,3,2,5,5,6,6)
        );

        Set<Integer> sinDuplicados = new HashSet<>(numeros);

        System.out.println("Lista sin duplicados: " + sinDuplicados);
        System.out.println("Tamaño de la lista: " + sinDuplicados.size());

    }
}
