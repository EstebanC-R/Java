package co.esteban.patrones.factory.producto;

import co.esteban.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {

    public PizzaNewYorkVegetariana() {
        super();
        nombre = "Pizza vegetariana New York";
        masa = "Masa integral vegana";
        salsa = "salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Berenjenas");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 25 min. a 150 grados Centigrados");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas.");
    }
}
