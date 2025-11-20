package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioMap_666;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> repeticiones = Arrays.asList(1,5,2,1,3,5,1,4);

        Map<Integer, Integer> frecuencia = new HashMap<>();

        System.out.println("Lista de números: " + repeticiones);

        for(Integer numero : repeticiones){
            // Usamos .getOrDefault()
            // a) Busca el conteo actual de 'numero'.
            // b) Si el número no existe (es la primera vez), devuelve 0.
            int conteoActual = frecuencia.getOrDefault(numero, 0);

            // c) Incrementa el conteo en 1 y actualiza el Map.
            // Si el número existía, sobrescribe el valor.
            // Si no existía, lo inserta con el valor 1 (0 + 1).
            frecuencia.put(numero, conteoActual + 1);
        }

        // 4. Imprime el Map de frecuencia final.
        System.out.println("\n--- Frecuencia Final (Map) ---");
        System.out.println(frecuencia);
    }
}
