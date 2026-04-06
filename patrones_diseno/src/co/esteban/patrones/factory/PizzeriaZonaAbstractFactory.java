package co.esteban.patrones.factory;


/**
 * PATRÓN ABSTRACT FACTORY — Clase abstracta principal (la "fábrica")
 *
 * Esta clase define DOS cosas:
 *
 *   1. El FLUJO FIJO de cómo se procesa una pizza (ordenarPizza).
 *      Siempre es: crear → preparar → cocinar → cortar → empaquetar.
 *      Ese orden nunca cambia sin importar la sucursal. Esto también
 *      se conoce como patrón Template Method.
 *
 *   2. El PUNTO DE VARIACIÓN: crearPizza() es abstract.
 *      Cada sucursal (California, New York) decide QUÉ pizza concreta
 *      instanciar según el tipo pedido. Esta clase no lo sabe ni le importa.
 *
 * El cliente (EjemploFactory) solo habla con este tipo abstracto.
 * Nunca necesita importar ni conocer PizzaCaliforniaQueso ni ninguna
 * clase concreta. Eso es el desacoplamiento que busca este patrón.
 */
public abstract class PizzeriaZonaAbstractFactory {

    // $ Método concreto: define el algoritmo completo del pedido.
    // $ Llama a crearPizza() internamente — en ese momento se ejecuta
    // $ la versión de la subclase concreta (California o New York).
    public PizzaProducto ordernarPizza(String tipo){
        // # crearPizza() es el único paso que varía entre sucursales.
        // # El polimorfismo se encarga de llamar a la implementación correcta.
        PizzaProducto pizza = crearPizza(tipo);

        System.out.println("------------ Fabricando la pizza" + pizza.getNombre() + " -------------");

        // # El resto del flujo es idéntico para todas las sucursales.
        pizza.preparar();
        pizza.cocinar();        // $ este método sí varía entre pizzas concretas
        pizza.cortar();         // $ este método sí varía entre pizzas concretas
        pizza.empaquetar();

        return pizza;
    }


    // % Método abstracto: la "pregunta" que cada subclase debe responder.
    // % "Dado este tipo de pizza, ¿cuál objeto concreto debo crear?"
    // % Sin esta línea, no habría forma de delegar la creación a las subclases.
    abstract PizzaProducto crearPizza(String tipo);
}
