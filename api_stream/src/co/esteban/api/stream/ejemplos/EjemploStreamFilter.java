package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Castaño", "Pepe Ramirez")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u ->  u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(u -> System.out.println(u));
        //nombres.forEach(System.out::println);

    }
}
