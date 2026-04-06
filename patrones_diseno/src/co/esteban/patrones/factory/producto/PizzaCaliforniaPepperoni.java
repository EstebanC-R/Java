package co.esteban.patrones.factory.producto;

import co.esteban.patrones.factory.PizzaProducto;


/**
 * PRODUCTO CONCRETO — Pizza California Pepperoni.
 *
 * Esta clase representa una pizza específica de la sucursal California.
 * Su responsabilidad es definir exactamente cómo ES esta pizza:
 * qué nombre tiene, qué masa, qué ingredientes, cómo se cocina y cómo se corta.
 *
 * PizzeriaCaliforniaFactory es la única que instancia esta clase.
 * El resto del sistema (incluido el cliente) solo la conoce como PizzaProducto.
 */
public class PizzaCaliforniaPepperoni extends PizzaProducto {

    public PizzaCaliforniaPepperoni() {
        super(); // ! inicializa la lista de ingredientes (definida en PizzaProducto)

        // # Se asignan los atributos heredados de PizzaProducto.
        // # Son "protected" en el padre, por eso podemos escribirlos directamente aquí.
        nombre = "Pizza California Pepperoni";
        masa = "Masa a la piedra gruesa";
        // ! (salsa no se asigna — quedará null, detalle del ejemplo)
        ingredientes.add("Pepperoni");
        ingredientes.add("Extra queso mozzarella");
        ingredientes.add("Aceitunas");
    }

    // ? Implementación obligatoria del método abstracto cocinar().
    // ? California la cocina más lento y a menor temperatura.
    @Override
    public void cocinar() {
        System.out.println("Cocinando a 50 min. a 55°C");
    }

    // ? Implementación obligatoria del método abstracto cortar().
    // ? California corta en rectángulos (New York lo hace en triángulos).
    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectángulos.");
    }
}
