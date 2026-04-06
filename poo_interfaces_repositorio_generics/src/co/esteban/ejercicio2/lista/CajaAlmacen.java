package co.esteban.ejercicio2.lista;

import java.util.ArrayList;
import java.util.List;

public class CajaAlmacen <T> {
    private List<T> caja;
    private final static int NUM_MAX = 5;

    public CajaAlmacen() {
        this.caja = new ArrayList<>();
    }

    public CajaAlmacen<T> addArticulo(T t){
        if(this.caja.size() <= NUM_MAX){
            this.caja.add(t);
        }else{
            throw new RuntimeException("Ya esta llena la caja.");
        }
        return this;
    }

    public List<T> getCaja() {
        return caja;
    }
}
