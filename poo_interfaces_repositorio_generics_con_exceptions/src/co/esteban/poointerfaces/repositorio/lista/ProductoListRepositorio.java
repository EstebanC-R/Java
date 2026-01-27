package co.esteban.poointerfaces.repositorio.lista;

import co.esteban.poointerfaces.modelo.Producto;
import co.esteban.poointerfaces.repositorio.AbstractaListRepositorio;
import co.esteban.poointerfaces.repositorio.Direccion;
import co.esteban.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void updateCliente(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {

        List<Producto> listaOrdenada = new ArrayList<>(dataSource);

        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir ==  Direccion.ASC){
                resultado = ordenar(campo, a, b);
            } else if(dir == Direccion.DESC){
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }


    public static int ordenar(String campo, Producto a, Producto b){
        int resultado = 0;
        switch (campo){
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripción" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
