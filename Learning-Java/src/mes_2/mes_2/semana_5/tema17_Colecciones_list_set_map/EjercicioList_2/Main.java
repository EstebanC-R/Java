package mes_2.semana_5.tema17_Colecciones_list_set_map.EjercicioList_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Esto se reedimensiona automaticamente, por lo que no es un problema agregar más
        // mientras que otros como la forma tradicional de crear un ArrayList si que es fijo
        // int numeros = new int[5];

        List<Integer> numeros = new ArrayList<>(5);

        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        numeros.add(50);
        numeros.add(60);

        System.out.println("La lista de números es: ");
        for(var i = 0; i < numeros.size(); i++) {
            if(numeros.get(i).equals(20)){
                numeros.set(i, 25);
            }
            System.out.println((i + 1) + " - " + numeros.get(i));
        }

        System.out.println("\nLista con números mayores a 30: ");
        for(var i = 0; i < numeros.size(); i++){
            if(numeros.get(i) > 30){
                System.out.println((i+1) + " - " + numeros.get(i));
            }
        }
    }
}
