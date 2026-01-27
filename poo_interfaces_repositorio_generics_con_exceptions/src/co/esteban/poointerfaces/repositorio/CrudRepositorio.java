package co.esteban.poointerfaces.repositorio;

import co.esteban.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void addCliente(T t) throws AccesoDatoException;
    void updateCliente(T t) throws AccesoDatoException;
    void deleteCliente(Integer id) throws AccesoDatoException;
}
