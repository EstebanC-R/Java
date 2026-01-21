package co.esteban.ejercicio2.modelo;

public class Electronico extends Articulo{
    private String marca;
    private int garantiaMeses;

    public Electronico(String nombre, double precio, String marca, int garantiaMeses) {
        super(nombre, precio);
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
    }

    public String getMarca() {
        return marca;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }
}
