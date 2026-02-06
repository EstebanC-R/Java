package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterCount {
    public static void main(String[] args) {

        long count = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Castaño", "Pepe Ramirez")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .count();

        System.out.println(count);

    }
}
