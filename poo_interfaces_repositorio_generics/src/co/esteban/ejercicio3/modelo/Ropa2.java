package co.esteban.ejercicio3.modelo;

import co.esteban.ejercicio2.modelo.Articulo;

public class Ropa2 extends Articulo2 {
    private String talla;
    private String material;

    public Ropa2(String nombre, double precio, String talla, String material) {
        super(nombre, precio);
        this.talla = talla;
        this.material = material;
    }

    public String getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }
}
