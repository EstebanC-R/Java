package mes_2.semana_5.tema17_Colecciones_list_set_map.EjercicioList_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();

        nombres.add("Manzana");
        nombres.add("Naranja");
        nombres.add("Pera");

        nombres.add("Fresa");
        nombres.add("Guayaba");

        System.out.println("Este es el tamaño de la lista: " + nombres.size());
        System.out.println("La posición 2 es: " + nombres.get(2));
    }
}
