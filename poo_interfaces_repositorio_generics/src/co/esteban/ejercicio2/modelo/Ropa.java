package co.esteban.ejercicio2.modelo;

public class Ropa extends Articulo{
    private String talla;
    private String material;

    public Ropa(String nombre, double precio, String talla, String material) {
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
