package co.esteba.pruebas.nivel2.models;

public class Producto {
    private Integer id;
    private String nombre;
    private double precio;
    private String categoria;
    private int stock;

    public Producto(Integer id, String nombre, double precio, String categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "\n- ID: " + id +
                "\n- Nombre: " + nombre +
                "\n- Precio: " + precio +
                "\n- Categoria: " + categoria +
                "\n- Stock: " + stock;
    }
}
