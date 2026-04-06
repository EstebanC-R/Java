package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {

        boolean existe = Stream
                .of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Castaño", "Pepe Ramirez")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch(u ->  u.getId().equals(1));

        System.out.println(existe);


        /*boolean resultado = false;

        List<Usuario> usuarios = Arrays.asList(new Usuario("Pato", "Guzman"),
                new Usuario("Paco", "Gonzales"),
                new Usuario("Pepa", "Gutierrez"),
                new Usuario("Pepe", "Castaño"),
                new Usuario("Pepe", "Ramirez")
        );

        for(Usuario u : usuarios){
            if(u.getId().equals(4)){
                System.out.println(u);
                resultado = true;
                break;
            }
        }

        System.out.println(resultado);*/
    }
}
