package co.esteba.pruebas.nivel2.repositories;

import java.util.List;
import java.util.Optional;

public interface Repositorio<T> {

    void agregar(T elemento);
    Optional<T> buscarPorId(Integer id);
    List<T> listarTodos();
    void eliminar(Integer id);
    int contar();
}
