package co.esteban.optional.ejemplo;

import co.esteban.optional.ejemplo.models.Celular;
import co.esteban.optional.ejemplo.models.Computador;
import co.esteban.optional.ejemplo.repositorio.CelularRepositorio;
import co.esteban.optional.ejemplo.repositorio.ComputadorRepositorio;
import co.esteban.optional.ejemplo.repositorio.Repositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        verResultados(repositorio, "C");

        // Optional<Computador> pc = repositorio.filtrar("Asus");

        /*if(pc.isPresent()){
            System.out.println(pc.get());
        } else {
            System.out.println("No se encontró");
        }*/

        Repositorio<Celular> repositorioCelulares = new CelularRepositorio()
                .addCelular(null)
                .addCelular(new Celular("Edge 69", "Motorola"))
                .addCelular(null)
                .addCelular(new Celular("Nova Y9", "Huawei"))
                .addCelular(new Celular("Galaxy S25", "Samsung"))
                .addCelular(new Celular("Poco X7", "Xiomi"))
                .addCelular(new Celular("Redmi 13 pro", "Xiomi"))
                .addCelular(new Celular("Redmi 14 pro", "Xiomi"));

        verResultados(repositorioCelulares, "r");
    }

    public static <T> void verResultados(Repositorio<T> repositorio, String busqueda){
        List<T> resultado = repositorio.listaDeResultadosSimilares(busqueda);
        if(!resultado.isEmpty()){
            System.out.println("\n- Primer resultado: " + resultado.getFirst());
            System.out.println("\n---------- Lista de Resultados ----------");
            resultado.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron resultados de búsqueda.");
        }
    }
}
