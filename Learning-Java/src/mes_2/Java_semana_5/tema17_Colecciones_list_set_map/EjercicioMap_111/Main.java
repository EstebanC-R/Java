package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioMap_111;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> paisesCapitales = new HashMap<>();

        paisesCapitales.put("Colombia", "Bogota");
        paisesCapitales.put("Perú", "Lima");
        paisesCapitales.put("España", "Madrid");
        
        String capitalDePeru = paisesCapitales.get("Perú");

        System.out.println("Total países: " + paisesCapitales.size());
        System.out.println("capital de Perú = " + capitalDePeru);
    }
}
