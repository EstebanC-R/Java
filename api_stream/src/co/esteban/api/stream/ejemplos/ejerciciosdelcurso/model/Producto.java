package co.esteban.api.stream.ejemplos.ejerciciosdelcurso.model;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private double precio;
    private int cantidad;

    public Producto(double precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
