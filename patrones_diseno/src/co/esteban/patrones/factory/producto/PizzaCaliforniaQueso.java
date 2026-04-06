package co.esteban.patrones.factory.producto;

import co.esteban.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza California Queso";
        masa = "Masa a la piedra delgada";
        salsa = "Salsa de tomate rucula";
        ingredientes.add("Extra queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso azul");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando a 35 min. a 100°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños triángulos");
    }
}

