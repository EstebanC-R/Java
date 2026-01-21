package co.esteban.ejercicio3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario <T extends Articulo2>{
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
