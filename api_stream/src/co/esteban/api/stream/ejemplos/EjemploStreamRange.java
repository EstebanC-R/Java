package co.esteban.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        IntStream rango = IntStream.range(1, 10).peek(System.out::println);

        // Integer resultado = rango.reduce(0, Integer::sum);
        // int resultado = rango.sum();
        IntSummaryStatistics stats = rango.summaryStatistics();
        System.out.println("Maximo = " + stats.getMax());
        System.out.println("Mínimo = " + stats.getMin());
        System.out.println("Suma = " + stats.getSum());
        System.out.println("Promedio = " + stats.getAverage());
        System.out.println("Total = " + stats.getCount());

    }
}
