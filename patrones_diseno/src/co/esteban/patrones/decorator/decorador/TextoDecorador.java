package co.esteban.patrones.decorator.decorador;

import co.esteban.patrones.decorator.Formateable;

/**
 * DECORADOR BASE — La clase que hace posible el apilamiento.
 *
 * Esta clase abstracta es el corazón técnico del patrón.
 * Tiene DOS características clave que trabajan juntas:
 *
 *   1. Implementa Formateable → puede usarse en cualquier lugar donde
 *      se espere un Formateable (es decir, puede "hacerse pasar" por el objeto real).
 *
 *   2. Contiene una referencia a otro Formateable (el campo "texto") →
 *      puede envolver a cualquier otro objeto que también sea Formateable,
 *      sea un Texto base u otro decorador.
 *
 * Gracias a esto, los decoradores se pueden anidar infinitamente:
 *   new DecoA(new DecoB(new DecoC(new Texto("hola"))))
 *
 * Cada decorador concreto hereda esta clase y solo necesita sobrescribir
 * darFormato() con su transformación específica.
 */
abstract public class TextoDecorador implements Formateable {

    // # Referencia al objeto "de adentro" (puede ser Texto u otro decorador).
    // # Cuando un decorador llama texto.darFormato(), ejecuta la cadena hacia adentro
    // # hasta llegar al Texto base, y el resultado vuelve capa por capa.
    protected Formateable texto;

    // # El constructor recibe el objeto a decorar.
    // # Así es como se construye la cadena: pasando cada capa a la siguiente.
    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
