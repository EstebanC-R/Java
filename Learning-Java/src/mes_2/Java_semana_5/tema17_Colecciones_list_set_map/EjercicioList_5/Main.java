package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioList_5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> matriz = new ArrayList<>();
        int filas = 3;
        int columnas = 3;

        for(var i = 0; i < filas; i++){
            List<Integer> fila = new ArrayList<>();
            for (var j = 0; j < columnas;j++){
                fila.add(0);
            }
            matriz.add(fila);
        }

        System.out.println(matriz);

        List<Integer> filaCentral = matriz.get(1);
        filaCentral.set(1, 5);

        System.out.println(" ---- Matriz 3*3 Final ----");
        for(List<Integer> filaActual : matriz){
            System.out.println(filaActual);
        }
    }
}
