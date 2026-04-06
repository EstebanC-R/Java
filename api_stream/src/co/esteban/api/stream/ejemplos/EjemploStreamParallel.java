package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
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

        long tiempo1 = System.currentTimeMillis();
        String resultado = lista.stream()
                .parallel()
                .map(u -> u.toString().toUpperCase())
                .peek(n -> System.out.println("Nombre Thread: " + Thread.currentThread().getName() +
                        " - " + n))
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if(nombre.contains("bruce".toUpperCase())){
                        return Stream.of(nombre);
                    }

                    return Stream.empty();
                }).findAny().orElse("No se encontró");

        long tiempo2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (tiempo2 - tiempo1));
        System.out.println(resultado);

    }
}
