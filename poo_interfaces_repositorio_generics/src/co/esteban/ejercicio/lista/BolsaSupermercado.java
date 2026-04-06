package co.esteban.ejercicio.lista;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado<T> {
    private List<T> bolsa;
    private static final int NUMERO_MAX = 5;

    public BolsaSupermercado() {
        this.bolsa = new ArrayList<>();
    }

    public BolsaSupermercado addProducto(T bolsa){
        if(this.bolsa.size() < NUMERO_MAX){
            this.bolsa.add(bolsa);
        }else {
            throw new RuntimeException("No queda espacio en la bolsa");
        }

        return this;
    }

    public List<T> getBolsa() {
        return bolsa;
    }
}
