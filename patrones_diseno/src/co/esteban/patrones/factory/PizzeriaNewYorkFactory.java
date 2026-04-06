package co.esteban.patrones.factory;

import co.esteban.patrones.factory.producto.PizzaNewYorkItaliana;
import co.esteban.patrones.factory.producto.PizzaNewYorkPepperoni;
import co.esteban.patrones.factory.producto.PizzaNewYorkVegetariana;


/**
 * FÁBRICA CONCRETA — Sucursal New York.
 *
 * Exactamente el mismo rol que PizzeriaCaliforniaFactory, pero con
 * sus propias pizzas concretas.
 *
 * Nota que tiene "Italiana" en vez de "Queso" — cada sucursal
 * puede ofrecer su propio catálogo sin romper nada del sistema.
 * Eso es posible porque el cliente solo conoce el tipo abstracto.
 */

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "Vegetariana" -> new PizzaNewYorkVegetariana();
            case "Pepperoni" -> new PizzaNewYorkPepperoni();
            case "Italiana" -> new PizzaNewYorkItaliana(); // * exclusiva de NY
            default -> null;
        };
    }
}
