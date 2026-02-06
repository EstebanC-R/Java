package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {


        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Milton", "Castaño"));
        lista.add(new Usuario("Pepe", "Ramirez"));
        lista.add(new Usuario("Yeison", "Soto"));
        lista.add(new Usuario("Mateo", "Toquica"));
        lista.add(new Usuario("Mateo", "Teo"));
        lista.add(new Usuario("Daniel", "Ramirez"));
        lista.add(new Usuario("Lola", "Poto"));
        lista.add(new Usuario("Bruce", "Lee"));
        lista.add(new Usuario("Bruce", "Willis"));

        Stream<String> nombres = lista.stream()
                .map(u -> u.getNombre()
                        .toUpperCase()
                        .concat(" " + u.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }

                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);
        System.out.println(nombres.count());

    }
}
