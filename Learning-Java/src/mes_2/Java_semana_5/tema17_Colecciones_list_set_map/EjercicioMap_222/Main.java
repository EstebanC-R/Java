package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioMap_222;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inventario = new HashMap<>();

        inventario.put("Laptop", 10);
        inventario.put("Mouse", 5);
        inventario.put("Teclado", 8);

        System.out.println(inventario);

        inventario.put("Laptop", 15);

        System.out.println(inventario);

        Integer cantidadEliminada = inventario.remove("Mouse");

        System.out.println("Se elimino del inventario ´Mouse´. Cantidad eliminada: " + cantidadEliminada);
        System.out.println("----- Inventario final ----");
        System.out.println(inventario);
    }
}
