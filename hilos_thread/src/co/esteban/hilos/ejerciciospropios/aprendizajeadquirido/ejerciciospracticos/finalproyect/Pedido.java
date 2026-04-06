package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos.finalproyect;

import java.util.concurrent.atomic.AtomicInteger;

public class Pedido implements Comparable<Pedido>{

    private int id;
    private static AtomicInteger ultimoId = new AtomicInteger(1);
    private String producto;

    public Pedido() {
        this.id = ultimoId.getAndIncrement();
        this.producto = ("Pedido #" + id);
    }

    public int getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    @Override
    public int compareTo(Pedido o) {
        return Integer.compare(o.id, this.id);
    }
}
