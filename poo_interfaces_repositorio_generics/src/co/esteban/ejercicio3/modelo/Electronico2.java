package co.esteban.ejercicio3.modelo;


public class Electronico2 extends Articulo2 {
    private String marca;
    private int garantiaMeses;

    public Electronico2(String nombre, double precio, String marca, int garantiaMeses) {
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
