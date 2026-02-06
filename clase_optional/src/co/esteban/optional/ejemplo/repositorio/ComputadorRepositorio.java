package co.esteban.optional.ejemplo.repositorio;

import co.esteban.optional.ejemplo.models.Computador;
import co.esteban.optional.ejemplo.models.Fabricante;
import co.esteban.optional.ejemplo.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador>{
    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("Ryzen 9", new Fabricante("AMD"));
        Computador asus = new Computador("Asus ROG", "Strix G512");
        asus.setProcesador(proc);
        dataSource.add(asus);
        dataSource.add(new Computador("MacBook Pro", "NVVK2CI"));
    }

    @Override
    public Optional<Computador> filtrarPorNombre(String nombre) {

        return dataSource.stream().filter(u -> u.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();

        /*for(Computador n : dataSource){
            if(n.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(n);
            }
        }
        return Optional.empty();*/
    }

    @Override
    public List<Computador> listaDeResultadosSimilares(String nombre) {
        return dataSource.stream().filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase())).toList();
    }
}
