package co.esteban.optional.ejemplo;

import co.esteban.optional.ejemplo.models.Computador;
import co.esteban.optional.ejemplo.repositorio.ComputadorRepositorio;
import co.esteban.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador pc = repositorio.filtrarPorNombre("Rog").orElseThrow(IllegalStateException::new);
        System.out.println(pc);

        String archivo = "documento.pdf";

        // % El Optional también resiste el filter, map, además de otros.
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();

        System.out.println(extension);

    }

}
