package co.esteban.api.stream.ejemplos.ejerciciosdelcurso;

import co.esteban.api.stream.ejemplos.ejerciciosdelcurso.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class EjercicioProducto {
    public static void main(String[] args) {

        /*
            $ El siguiente requerimiento es para una lista de productos
            $ List<Producto> , de 3 a 5 elementos, se pide calcular el
            $ importe (precio por cantidad) y sumarlos.

            $ La clase Producto debe tener el atributo precio del tipo
            $ double y cantidad int, entonces utilizando stream convertir
            $ la lista de productos en el gran total del tipo double.
        */

        List<Producto> productos = new ArrayList<>();

        Producto p1 = new Producto(2000, 2);
        Producto p2 = new Producto(4032.1, 4);
        Producto p3 = new Producto(1200, 1);
        Producto p4 = new Producto(6082.1, 3);

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        double total = productos.stream().mapToDouble(a -> a.getPrecio() * a.getCantidad()).sum();

        System.out.printf("Total : %.3f", total);

    }
}
