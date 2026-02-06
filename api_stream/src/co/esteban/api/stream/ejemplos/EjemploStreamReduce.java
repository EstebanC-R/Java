package co.esteban.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Castaño", "Pepe Ramirez","Paco Gonzales",
                        "Paco Gonzales")
                .distinct();

        String resultado = nombres.reduce("resultado concatenación ", (a, b) -> a + " | " + b);
        System.out.println(resultado);

    }
}
