package co.esteba.pruebas.nivel3.models;

import java.time.LocalDate;

public class Venta {
    private String producto;
    private int cantidad;
    private double precio;
    private LocalDate fecha;
    private String vendedor;

    public Venta(String producto, int cantidad, double precio, LocalDate fecha, String vendedor) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.vendedor = vendedor;
    }


    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getIngreso(){
        return cantidad * precio;
    }

    @Override
    public String toString() {
        return String.format("\n- %-15s: %s\n- %-15s: %d\n- %-15s: %.0f\n- %-15s: %s\n- %-15s: %s",
                "Producto", producto,
                "Cantidad", cantidad,
                "Precio", precio,
                "Fecha", fecha,
                "Vendedor", vendedor
        );
    }
}
