package co.esteban.patrones.factory.producto;

import co.esteban.patrones.factory.PizzaProducto;


/**
 * PRODUCTO CONCRETO — Pizza New York Pepperoni.
 *
 * Misma estructura que PizzaCaliforniaPepperoni, pero con los valores
 * propios de la sucursal New York: masa delgada, salsa de tomate,
 * cocción más rápida a mayor temperatura, y corte en triángulos.
 *
 * La diferencia entre sucursales se ve claramente comparando
 * cocinar() y cortar() con su equivalente de California.
 */
public class PizzaNewYorkPepperoni extends PizzaProducto {

    public PizzaNewYorkPepperoni() {
        super();
        nombre = "Pizza Pepperoni New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Extra pepperoni");
        ingredientes.add("Aceitunas");

    }

    // ? NY cocina más rápido y a mayor temperatura que California.
    @Override
    public void cocinar() {
        System.out.println("Cocinando por 40 min. a 90°C ");
    }


    // ? NY corta en triángulos — detalle que viene definido por cada producto concreto,
    // ? no por la fábrica ni por PizzaProducto.
    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triángulos.");
    }
}
