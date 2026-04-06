package co.esteban.ejercicio3.lista;

import co.esteban.ejercicio3.modelo.Articulo2;

import java.util.ArrayList;
import java.util.List;

public class Inventario <T extends Articulo2>{

    // % Aquí usamos un genérico T que está limitado a la clase Articulo2.
    // % Esto significa que solo podemos usar Articulo2 o clases que hereden de ella.
    // % Si intentamos poner un tipo que no tenga relación con Articulo2,
    // % el compilador marcará un error antes de ejecutar el programa.
    // % Así nos aseguramos de que todos los objetos en Inventario
    // % tengan las características de Articulo2.

    List<T> inventario;
    private final static int NUM_MAX = 9;

    public Inventario() {
        this.inventario = new ArrayList<>();
    }

    public Inventario<T> addInventario(T objeto){
        if(this.inventario.size() <= NUM_MAX){
            this.inventario.add(objeto);
        }else {
            throw new RuntimeException("El inventario esta a full.");
        }
        return this;
    }

    public List<T> getInventario() {
        return inventario;
    }

    public double calcularTotal(){
        double total = 0;

        for(T i : getInventario()){
            total += i.getPrecio();
        }

        return total;
    }
}
