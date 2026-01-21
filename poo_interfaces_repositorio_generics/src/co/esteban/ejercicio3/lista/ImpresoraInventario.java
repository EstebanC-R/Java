package co.esteban.ejercicio3.lista;

import co.esteban.ejercicio3.modelo.Articulo2;
import co.esteban.ejercicio3.modelo.Electronico2;

import java.util.List;

public class ImpresoraInventario {
    public static void imprimir(List<? extends Articulo2> lista) {

        for (Articulo2 art : lista) {
            System.out.println("Nombre: " + art.getNombre());
            System.out.println("Precio: " + art.getPrecio());
            System.out.println("----------------------");
        }
    }
}
