package co.esteban.ejercicio2.modelo;

public class Mueble extends Articulo{
    private double peso;
    private boolean requiereArmado;

    public Mueble(String nombre, double precio, double peso, boolean requiereArmado) {
        super(nombre, precio);
        this.peso = peso;
        this.requiereArmado = requiereArmado;
    }

    public double getPeso() {
        return peso;
    }

    public boolean isRequiereArmado() {
        return requiereArmado;
    }
}
