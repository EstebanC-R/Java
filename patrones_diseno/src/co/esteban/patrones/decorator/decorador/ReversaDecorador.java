package co.esteban.patrones.decorator.decorador;

import co.esteban.patrones.decorator.Formateable;

/**
 * DECORADOR CONCRETO — Invierte el texto de derecha a izquierda.
 *
 * Recibe el resultado de la cadena interior y lo voltea completamente.
 * Ejemplo: "HOLA MUNDO" → "ODNUM ALOH"
 *
 * StringBuilder.reverse() hace el trabajo pesado.
 * Este decorador solo orquesta: pide el texto de adentro, lo invierte, lo devuelve.
 */
public class ReversaDecorador extends TextoDecorador {

    public ReversaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        // Se crea un StringBuilder con el texto ya procesado por las capas interiores.
        // reverse() lo invierte en el lugar (modifica el mismo StringBuilder).
        // toString() lo convierte de vuelta a String para devolverlo.
        StringBuilder sb = new StringBuilder(texto.darFormato());
        return sb.reverse().toString();
    }
}
