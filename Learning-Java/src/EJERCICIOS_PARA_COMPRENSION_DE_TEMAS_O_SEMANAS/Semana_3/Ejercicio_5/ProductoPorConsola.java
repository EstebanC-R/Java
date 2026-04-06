package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_5;

import java.util.Objects;

public class ProductoPorConsola {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public ProductoPorConsola(String codigo, String nombre, double precio, int stock){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return  precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        ProductoPorConsola nuevoProducto = (ProductoPorConsola) obj;
        return Objects.equals(this.codigo, nuevoProducto.codigo);
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

    @Override
    public String toString(){
        return String.format(
                "Código : %s\nNombre : %s\nPrecio : %.2f\nStock : %02d\n",
                codigo, nombre, precio, stock
        );
    }
}
