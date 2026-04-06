package co.esteban.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduceInt {
    public static void main(String[] args) {

        Stream<Integer> nombres = Stream.of(10, 15, 25, 40)
                .distinct();

        Integer resultado = nombres.reduce(0, Integer::sum);
        System.out.println(resultado);

    }
}
