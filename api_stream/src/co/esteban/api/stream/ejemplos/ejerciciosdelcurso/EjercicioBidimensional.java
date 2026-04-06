package co.esteban.api.stream.ejemplos.ejerciciosdelcurso;

import java.util.Arrays;
import java.util.stream.Stream;

public class EjercicioBidimensional {
    public static void main(String[] args) {


        String[][] lenguajes = {
                {"Rust", "C"},
                {"Python", "C#"},
                {"JavaScript", "JavaScript", "C"},
                {"Java"},
                {"PHP", "Kotlin"},
                {"Groove"},
                {"Kotlin"}
        };

        Arrays.stream(lenguajes)
                .flatMap(u -> Arrays.stream(u))
                .distinct()
                .forEach(System.out::println);

    }
}
