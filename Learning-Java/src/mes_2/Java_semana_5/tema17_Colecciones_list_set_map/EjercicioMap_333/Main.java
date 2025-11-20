package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioMap_333;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inventario = new HashMap<>();

        inventario.put("Laptop", 10);
        inventario.put("Mouse", 5);
        inventario.put("Teclado", 8);

        for(Map.Entry<String, Integer> entrada : inventario.entrySet()){
            String producto = entrada.getKey();
            Integer cantidad = entrada.getValue();

            System.out.println("- Producto: " + producto + "\n- Cantidad: " + cantidad + " unidades disponibles.\n\n");
        }
    }
}
