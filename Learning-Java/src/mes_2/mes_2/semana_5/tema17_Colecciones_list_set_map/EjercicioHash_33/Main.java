package mes_2.semana_5.tema17_Colecciones_list_set_map.EjercicioHash_33;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> A = new HashSet<>(
                Arrays.asList("Rojo", "Azul", "Amarillo")
        );

        Set<String> B = new HashSet<>(
                Arrays.asList("Naranja", "Verde", "Morado", "Amarillo")
        );

        System.out.println("Lista A: " + A);
        System.out.println("Lista B: " + B);

        Set<String> interseccion = new HashSet<>(A);

        interseccion.retainAll(B);

        System.out.println("La lista intersección tiene solo: " + interseccion);
    }
}
