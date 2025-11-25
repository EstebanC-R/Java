package EJERCICIOS_MES_2.Semana05_sistema_de_inventario_usando_hashmap_y_arraylist;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nom, double preci, int cant){
        this.nombre = nom;
        this.precio = preci;
        this.cantidad = cant;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nom){
        this.nombre = nom;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double preci){
        this.precio = preci;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
