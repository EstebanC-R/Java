package co.esteban.patrones.factory;

import java.util.ArrayList;
import java.util.List;


/**
 * PRODUCTO ABSTRACTO del patrón Abstract Factory.
 *
 * Representa "qué es una pizza" en términos generales.
 * Define los atributos comunes (nombre, masa, salsa, ingredientes)
 * y los pasos del proceso que son iguales para todas las pizzas.
 *
 * Los pasos que VARÍAN entre pizzas (cocinar, cortar) se declaran
 * abstract para obligar a cada pizza concreta a implementar su versión.
 *
 * Así, la fábrica puede trabajar con cualquier pizza usando este tipo,
 * sin importar si es California Queso o New York Italiana.
 */

public abstract class PizzaProducto {

    // # Atributos comunes a toda pizza. Son "protected" para que las
    // # subclases puedan asignarlos directamente en su constructor.
    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;

    public PizzaProducto() {
        // % Se inicializa la lista aquí para que todas las subclases
        // % hereden una lista para usar con .add().
        this.ingredientes = new ArrayList<>();
    }


    // # Paso concreto: siempre hace lo mismo para cualquier pizza.
    // # Lee los atributos que cada subclase asignó en su constructor.
    public void preparar(){
        System.out.println("Preparando " + nombre);
        System.out.println("Seleccionando la masa " + masa);
        System.out.println("Agregando la salsa " + salsa);
        System.out.println("Agregando ingredientes: ");
        ingredientes.forEach(System.out::println);
    }

    // * Paso variable: cada pizza tiene su temperatura y tiempo.
    // * La subclase concreta (ej. PizzaCaliforniaPepperoni) lo implementa.
    abstract public void cocinar();

    // # Paso variable: algunas se cortan en triángulos, otras en rectángulos.
    // # La subclase concreta lo decide.
    abstract public void cortar();

    // $ Paso concreto: el empaque es igual para todas.
    public void empaquetar(){
        System.out.println("Poniendo la pizza en una caja de empaque...");
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return "\n- Nombre: " + nombre +
                "\n- Masa: " + masa +
                "\n- Salsa: " + salsa +
                "\n- Ingredientes: " + ingredientes;
    }
}
