package co.esteban.ejerciciosherencia.ejercicio3;

public class NoPerecedero extends Producto {
    private int contenido;
    private int calorias;

    public NoPerecedero(String nombre, double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- Contenido: " + contenido +
                "\n- Calorías: " + calorias;
    }
}
