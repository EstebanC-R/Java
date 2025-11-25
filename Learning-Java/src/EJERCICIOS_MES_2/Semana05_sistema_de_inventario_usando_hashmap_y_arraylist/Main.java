package EJERCICIOS_MES_2.Semana05_sistema_de_inventario_usando_hashmap_y_arraylist;

public class Main {
    public static void main(String[] args) {
        Inventario<Producto> almacen = new Inventario<>();

        almacen.agregar("001", new Producto("Celular", 1300000.00, 20));
        almacen.agregar("002", new Producto("Portatil", 2500000.00, 10));

        Producto p = almacen.buscar("001");
        System.out.println(p.getNombre());
    }
}
