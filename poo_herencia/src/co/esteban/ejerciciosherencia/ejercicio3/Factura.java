package co.esteban.ejerciciosherencia.ejercicio3;

import java.util.Date;

public class Factura {

    private Cliente cliente;
    private Vendedor vendedor;
    private Producto[] productos;
    private Date fecha;
    private int contadorProductos;

    public Factura(Cliente cliente, Vendedor vendedor) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.productos = new Producto[4];
        this.fecha = new Date();
        this.contadorProductos = 0;
    }

    public void agregarProducto(Producto producto) {
        if (producto != null && contadorProductos < productos.length) {
            productos[contadorProductos] = producto;
            contadorProductos++;
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            if (p != null) {
                total += p.getPrecio();
            }
        }
        return total;
    }


    @Override
    public String toString() {
        StringBuilder detalle = new StringBuilder();

        detalle.append("======= FACTURA =======\n");
        detalle.append("Fecha: ").append(fecha).append("\n");

        detalle.append(cliente).append("\n");
        detalle.append(vendedor).append("\n");

        detalle.append("\n--- Productos ---\n");
        for (Producto p : productos) {
            if (p != null) {
                detalle.append(p).append("\n");
            }
        }

        detalle.append("\nTOTAL A PAGAR: ").append(calcularTotal());

        return detalle.toString();
    }
}
