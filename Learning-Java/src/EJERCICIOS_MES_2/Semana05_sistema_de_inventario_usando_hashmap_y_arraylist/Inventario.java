package EJERCICIOS_MES_2.Semana05_sistema_de_inventario_usando_hashmap_y_arraylist;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventario <T> {
    private HashMap<String, T> items;

    public Inventario(){
        items = new HashMap<>();
    }

    public void agregar(String codigo, T item){ // Se ingresa la clase, ya que recordemos que el Generic T puede ser objeto u otra cosa.
        items.put(codigo, item);
    }

    public T buscar(String codigo){
        return items.get(codigo);
    }

    public ArrayList<T> obtenerTodos(){
        return new ArrayList<>(items.values());
    }

    public boolean eliminar(String codigo){
        return items.remove(codigo) != null;
    }
}
