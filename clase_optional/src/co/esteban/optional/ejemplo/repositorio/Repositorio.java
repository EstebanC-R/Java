package co.esteban.optional.ejemplo.repositorio;

import co.esteban.optional.ejemplo.models.Computador;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {

    Optional<T> filtrarPorNombre(String nombre);
    List<T> listaDeResultadosSimilares(String nombre);

}
