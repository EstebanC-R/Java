package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioHash_55;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String texto = "El gato de color naranja es el gato que tambien tiene el color blanco";

        String[] palabrasArray = texto.split(" ");
        int totalPalabras = palabrasArray.length;

        Set<String> palabrasUnicas = new HashSet<>(
                Arrays.asList(palabrasArray)
        );

        int totalPalabrasUnicas = palabrasUnicas.size();

        System.out.println("Texto original: " + texto);
        System.out.println("Total palabras: " + totalPalabras);

        System.out.println("\nPalabras únicas: " + palabrasUnicas);
        System.out.println("Total palabras únicas: " + totalPalabrasUnicas);

    }
}
