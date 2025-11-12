package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejericicio_10;

import java.util.Objects;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;

    public Producto(String codigo, String nombre, double precio, int cantidad, String categoria){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
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
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }


    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Producto product = (Producto) obj;
        return Objects.equals(this.codigo, product.codigo);
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

    @Override
    public String toString(){
        return String.format(
                "\n------------------------------------\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %.2f\n%-15s : %d\n%s\n",
                "- Código", getCodigo(),
                "- Nombre", getNombre(),
                "- Categoria", getCategoria(),
                "- Precio", getPrecio(),
                "- Cantidad", getCantidad(),
                "------------------------------------"
        );
    }

}
