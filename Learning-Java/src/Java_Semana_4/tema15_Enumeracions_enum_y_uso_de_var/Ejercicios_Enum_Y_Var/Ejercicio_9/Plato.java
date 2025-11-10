package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_9;

import java.util.ArrayList;

public class Plato {
    private String nombre;
    private double precio;
    private CategoriaPlato categoria;
    ArrayList<Plato> platos = new ArrayList<>();

    public Plato(String nombre, double precio, CategoriaPlato categoria){
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre(){
        return nombre;
    }

    public CategoriaPlato getCategoria(){
        return categoria;
    }

    public double getPrecio(){
        return precio;
    }

    @Override
    public String toString(){
        return String.format(
                "\n---------------------------------------\n%-15s : %s\n%-15s : $%.2f\n%-15s : %s - %s\n%s",
                "- Nombre", nombre,
                "- Precio", precio,
                "- Categoria", categoria.getNombreCategoria(), categoria.getIconoCategoria(),
                "---------------------------------------\n"
        );
    }
}
