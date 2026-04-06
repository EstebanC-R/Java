package co.esteban.patrones.decorator.decorador;

import co.esteban.patrones.decorator.Formateable;

/**
 * DECORADOR CONCRETO — Agrega una línea de guiones bajos debajo del texto.
 *
 * Calcula el largo del texto resultante y dibuja tantos '_' como caracteres tenga.
 * El subrayado se adapta automáticamente sin importar cuánto mida el texto.
 *
 * Ejemplo de salida:
 *   !NOTLIM LAT EUQ ALOH
 *   ____________________
 */
public class SubrayadoDecorador extends TextoDecorador {

    public SubrayadoDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        // # Primero se obtiene el texto procesado por las capas interiores.
        // # Su longitud determina cuántos '_' se necesitan.
        int largo = texto.darFormato().length();

        // # StringBuilder se usa para construir el resultado eficientemente.
        // # Se parte del texto ya procesado y se le agrega el subrayado.
        StringBuilder sb = new StringBuilder(texto.darFormato());
        sb.append("\n"); // $ salto de línea para que el subrayado quede abajo
        for (int i = 0; i < largo; i++) {
            sb.append("_"); // $ un guion por cada carácter del texto
        }
        return sb.toString();
    }
}
