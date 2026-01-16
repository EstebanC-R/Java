package co.esteban.ejercicios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdenCompra {
    private int id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private int indiceProducto = 0;

    private static int ultimoId;

    public OrdenCompra(String descripcion) {
        this.id = ++ultimoId;
        this.productos = new Producto[4];
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void addProducto(Producto producto) {
        if (indiceProducto < this.productos.length) {
            this.productos[indiceProducto++] = producto;
        } else {
            System.out.println("No se pueden agregar más productos, el límite es 5.");
        }
    }

    public int sumaTotal(){
        int suma = 0;
        for(Producto p : productos){
            if(p != null){
                suma += p.getPrecio();
            }
        }
        return suma;
    }

    SimpleDateFormat formato = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy - hh:mm:ss");

    public void detalles(){
        System.out.printf("\n\n ----------- Número de Orden #%d -----------\n", this.id);
        System.out.printf("- %-15s : %s %s\n", "Nombre Cliente", this.cliente.getNombre(), this.cliente.getApellido());
        System.out.printf("- %-15s : %s\n", "Categoria", this.descripcion);
        System.out.printf("- %-15s : %s\n", "Fecha", formato.format(fecha));

        System.out.println("\n========= Canasta de Compras =========");
        int contador = 1;
        for(Producto p : productos){
            if(p != null){
                System.out.printf("- %-15s : %d\n", "Producto Num", contador);
                System.out.printf("- %-15s : %s\n", "Fabricante", p.getFabricante());
                System.out.printf("- %-15s : %s\n", "Nombre", p.getNombre());
                System.out.printf("- %-15s : %d\n\n", "Precio", p.getPrecio());
                contador++;
            }
        }
        System.out.println("- Total = $" + sumaTotal());
        System.out.println("\n================ // ================");
    }
}
