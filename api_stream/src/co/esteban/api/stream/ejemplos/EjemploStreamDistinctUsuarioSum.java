package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        IntStream largoNombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Castaño", "Pepe Ramirez",
                        "Pato Guzman", "Pato Guzman", "Pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())
                .peek(System.out::println);

        //largoNombres.forEach(System.out::println);

        IntSummaryStatistics stats = largoNombres.summaryStatistics();
        System.out.println("Total: " + stats.getSum());
        System.out.println("Maximo: " + stats.getMax());
        System.out.println("Minio: " + stats.getMin());
        System.out.println("Promedio: " + stats.getAverage());

    }
}
