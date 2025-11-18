package mes_2.semana_5.tema17_Colecciones_list_set_map.EjercicioHash_44;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

        Set<String> diferencia = new HashSet<>(A);

        diferencia.removeAll(B);

        // Basicamente realiza una diferencia de conjuntos.
        // SetA.removeAll(SetB) modifica el SetA eliminando todos los elementos que tiene en común con el SetB.
        // El resultado final que queda en SetA es: los elementos que solo existen en SetA y no en SetB.
        System.out.println("Diferencia: " + diferencia);
    }
}
