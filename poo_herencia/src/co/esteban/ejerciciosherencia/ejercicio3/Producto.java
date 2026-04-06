package co.esteban.ejerciciosherencia.ejercicio3;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "\n======= Datos Producto =======" +
                "\n- Nombre producto: " + nombre +
                "\n- Precio: " + precio;
    }
}
