package co.esteba.pruebas.nivel2.repositories;

import co.esteba.pruebas.nivel2.models.Producto;
import co.esteba.pruebas.nivel2.models.RepositorioBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RepositorioProducto extends RepositorioBase<Producto> {
    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return lista.stream().filter(e -> id.equals(e.getId())).findAny();
    }

    @Override
    public void eliminar(Integer id) {
        lista.removeIf(e -> id.equals(e.getId()));
    }

    public List<Producto> buscarPorCategoria(String categoria){
        if(lista.stream().filter(e -> e.getCategoria().equalsIgnoreCase(categoria)).toList().isEmpty()){
            System.out.println("No se ha encontrado un producto con esta categoría: " + categoria);
            return new ArrayList<>();
        }
        return lista.stream().filter(e -> e.getCategoria().equalsIgnoreCase(categoria)).toList();
    }

    public List<Producto> buscarPorRangoPrecio(double min, double max){
        if(lista.stream().filter(e -> e.getPrecio() >= min && e.getPrecio() <= max).toList().isEmpty()){
            System.out.println("No se han encontrado productos en este rango de precios: " + min + " - " + max);
            return new ArrayList<>();
        }
        return lista.stream().filter(e -> e.getPrecio() >= min && e.getPrecio() <= max).toList();
    }

    public Optional<Producto> productoMasCaro(){
        return lista.stream().max(Comparator.comparing(Producto::getPrecio));
    }

    public double calcularValorInventario(){
        if(lista.isEmpty()){
            System.out.println("No hay productos a calcular.");
            return 0.0;
        }
        return lista.stream().mapToDouble(p -> p.getPrecio() * p.getStock()).sum();
    }
}
