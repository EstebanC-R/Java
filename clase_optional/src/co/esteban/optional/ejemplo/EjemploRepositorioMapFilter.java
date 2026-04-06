package co.esteban.optional.ejemplo;

import co.esteban.optional.ejemplo.models.Computador;
import co.esteban.optional.ejemplo.models.Fabricante;
import co.esteban.optional.ejemplo.models.Procesador;
import co.esteban.optional.ejemplo.repositorio.ComputadorRepositorio;
import co.esteban.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        // $ Si lo que devuelve es un valor normal distinto de Optional se utiliza map
        // $ de lo contrario se utiliza un flatMap.

        String f = repositorio.filtrarPorNombre("asu")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(fab -> "amd".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");

        System.out.println("Fabricante: " + f);
    }
}
