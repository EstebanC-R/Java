package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioMap_555;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> mapOriginal = new HashMap<>();

        mapOriginal.put("a", 1);
        mapOriginal.put("b", 2);
        mapOriginal.put("c", 3);

        System.out.println("------------------------ Map Original ------------------------\n" + mapOriginal);

        Map<Integer, String> mapInvertido = new HashMap<>();

        for(Map.Entry<String, Integer> entrada : mapOriginal.entrySet()){
            mapInvertido.put(entrada.getValue(), entrada.getKey());
        }

        System.out.println("------------------------ Map Original ------------------------\n" + mapInvertido);
    }
}
