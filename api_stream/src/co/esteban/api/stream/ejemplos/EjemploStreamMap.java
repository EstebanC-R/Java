package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Castaño")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(u -> System.out.println(u.getNombre()))
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                    return usuario;
                });

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(u -> System.out.println(u));
        //nombres.forEach(System.out::println);

    }
}
