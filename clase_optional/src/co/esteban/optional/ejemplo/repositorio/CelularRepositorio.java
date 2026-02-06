package co.esteban.optional.ejemplo.repositorio;

import co.esteban.optional.ejemplo.models.Celular;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CelularRepositorio implements Repositorio<Celular>{

    private List<Celular> storage;

    public CelularRepositorio() {
        this.storage = new ArrayList<>();
    }

    public CelularRepositorio addCelular(Celular celular){
        if(celular != null){
            storage.add(celular);
        }

        return this;
    }

    @Override
    public Optional<Celular> filtrarPorNombre(String nombre) {
        return storage.stream().filter(celu -> celu.getNombre().toLowerCase().contains(nombre.toLowerCase())).findFirst();
    }

    @Override
    public List<Celular> listaDeResultadosSimilares(String nombre) {
        return storage.stream().filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())).toList();
    }
}
