package mes_2.semana_5.tema17_Colecciones_list_set_map.EjercicioList_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>(
                Arrays.asList("Banana", "Uva", "Melocoton", "Sandia")
        );
        System.out.println(palabras);

        Collections.sort(palabras, Collections.reverseOrder());

        System.out.println("Lista en orden decendente: " + palabras);
    }
}
