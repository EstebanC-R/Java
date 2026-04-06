package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        Usuario usuario = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Castaño", "Pepe Ramirez")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter(u ->  u.getId().equals(4))
                .findFirst().orElseGet(() -> new Usuario("John", "Doe"));

        System.out.println(usuario);


    }
}
