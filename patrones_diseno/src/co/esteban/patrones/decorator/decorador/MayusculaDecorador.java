package co.esteban.patrones.decorator.decorador;

import co.esteban.patrones.decorator.Formateable;

/**
 * DECORADOR CONCRETO — Convierte el texto a mayúsculas.
 *
 * Patrón de funcionamiento (igual en todos los decoradores):
 *   1. Llama a texto.darFormato() → dispara la cadena hacia adentro.
 *   2. Recibe el resultado ya procesado por las capas anteriores.
 *   3. Aplica SU transformación sobre ese resultado.
 *   4. Devuelve el texto transformado a la capa de afuera.
 *
 * En este caso: recibe "hola que tal" → devuelve "HOLA QUE TAL".
 * Si hay capas debajo (ej. ReversaDecorador), primero se ejecuta
 * la reversa, y luego este decorador convierte ESE resultado a mayúsculas.
 */
public class MayusculaDecorador extends TextoDecorador {

    public MayusculaDecorador(Formateable texto) {
        super(texto); // % guarda la referencia al objeto de adentro
    }

    @Override
    public String darFormato() {
        // % texto.darFormato() → ejecuta toda la cadena interior primero.
        // % .toUpperCase()     → aplica la transformación de esta capa.
        return texto.darFormato().toUpperCase();
    }
}
