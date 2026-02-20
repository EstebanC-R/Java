package co.esteba.pruebas.nivel2.models;

import co.esteba.pruebas.nivel2.repositories.Repositorio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public abstract class RepositorioBase <T> implements Repositorio<T> {

    protected List<T> lista = new ArrayList<>();

    @Override
    public void agregar(T elemento) {
        if(elemento != null){
            lista.add(elemento);
        }
    }

    @Override
    public abstract Optional<T> buscarPorId(Integer id);

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(lista);
    }

    @Override
    public abstract void eliminar(Integer id);

    @Override
    public int contar() {
        return lista.size();
    }

    public List<T> ordenarPor(Comparator<T> comparador) {
        return lista.stream()
                .sorted(comparador)
                .toList();
    }

}
