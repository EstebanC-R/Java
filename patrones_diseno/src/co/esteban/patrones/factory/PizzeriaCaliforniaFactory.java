package co.esteban.patrones.factory;

import co.esteban.patrones.factory.producto.PizzaCaliforniaPepperoni;
import co.esteban.patrones.factory.producto.PizzaCaliforniaQueso;
import co.esteban.patrones.factory.producto.PizzaCaliforniaVegetariana;



/**
 * FÁBRICA CONCRETA — Sucursal California.
 *
 * Su única responsabilidad es implementar crearPizza():
 * decidir QUÉ objeto concreto instanciar según el tipo pedido.
 *
 * El cliente nunca llega hasta aquí directamente. Él solo conoce
 * PizzeriaZonaAbstractFactory. Esta clase es el detalle de implementación
 * que el cliente no necesita ver.
 *
 * Si mañana California quiere agregar una pizza nueva (ej. "BBQ"),
 * solo se agrega un case aquí. El resto del programa no cambia.
 */

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{

    @Override
    PizzaProducto crearPizza(String tipo) {

        // % switch expression (Java 14+): devuelve el objeto directamente.
        // % Cada case instancia una pizza concreta distinta.
        // % La clase padre (PizzeriaZonaAbstractFactory) recibirá este objeto
        // % como PizzaProducto y lo procesará sin saber cuál es exactamente.
        return switch (tipo){
            case "Vegetariana" -> new PizzaCaliforniaVegetariana();
            case "Queso" -> new PizzaCaliforniaQueso();
            case "Pepperoni" -> new PizzaCaliforniaPepperoni();
            default -> null; // ! tipo no reconocido
        };
    }
}
