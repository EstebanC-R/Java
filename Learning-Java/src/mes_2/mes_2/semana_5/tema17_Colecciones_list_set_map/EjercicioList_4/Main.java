package mes_2.semana_5.tema17_Colecciones_list_set_map.EjercicioList_4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();

        for(var i = 0; i < 10; i++){
            numeros.add(i, (i+1));
        }

        System.out.println("Lista: " + numeros);

        List<Integer> sublista = numeros.subList(3, 7);
        System.out.println("Nueva Lista: " + sublista);
    }
}
