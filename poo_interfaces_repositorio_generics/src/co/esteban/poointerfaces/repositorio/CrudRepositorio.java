package co.esteban.poointerfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id);
    void addCliente(T t);
    void updateCliente(T t);
    void deleteCliente(Integer id);
}
