package co.esteban.patrones.factory.ejemplo;

import co.esteban.patrones.factory.PizzaProducto;
import co.esteban.patrones.factory.PizzeriaCaliforniaFactory;
import co.esteban.patrones.factory.PizzeriaNewYorkFactory;
import co.esteban.patrones.factory.PizzeriaZonaAbstractFactory;

/**
 * CLIENTE del patrón Abstract Factory.
 *
 * Este es el código que "usa" las fábricas. Observa lo que NO hace:
 *   - Nunca importa PizzaCaliforniaQueso ni ninguna pizza concreta.
 *   - Nunca hace "new Pizza...()".
 *   - Solo habla con PizzeriaZonaAbstractFactory y PizzaProducto (los abstractos).
 *
 * Eso significa que si mañana se agrega una sucursal "Miami", este
 * archivo no necesita cambiar en absoluto.
 */

public class EjemploFactory {
    public static void main(String[] args) {
        // # Se crean las dos fábricas concretas.
        // # A partir de aquí, el cliente las trata como PizzeriaZonaAbstractFactory.
        // # El tipo real (California o NY) quedó "encapsulado" dentro del objet
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();


        // # ordernarPizza() ejecuta el flujo completo: crearPizza → preparar → cocinar → cortar → empaquetar.
        // # La fábrica "california" sabe internamente que "Queso" → PizzaCaliforniaQueso.
        // # El cliente no lo sabe ni necesita saberlo.
        PizzaProducto pizza = california.ordernarPizza("Queso");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());

        // # La fábrica "ny" sabe que "Pepperoni" → PizzaNewYorkPepperoni.
        // # Mismo método, distinto resultado. Eso es polimorfismo trabajando para el patrón.
        pizza = ny.ordernarPizza("Pepperoni");
        System.out.println("Andres ordena una " + pizza.getNombre());

        pizza = california.ordernarPizza("Vegetariana");
        System.out.println("James ordena una " + pizza.getNombre());

        pizza = ny.ordernarPizza("Vegetariana");
        System.out.println("Linus ordena la pizza " + pizza.getNombre());

        pizza = california.ordernarPizza("Pepperoni");
        System.out.println("John ordena la pizza " + pizza.getNombre());


        // # toString() de PizzaProducto muestra todos los atributos que
        // # la pizza concreta asignó en su constructor.
        System.out.println("\npizza = " + pizza );
    }
}
