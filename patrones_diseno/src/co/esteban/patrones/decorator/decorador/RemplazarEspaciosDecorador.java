package co.esteban.patrones.decorator.decorador;

import co.esteban.patrones.decorator.Formateable;

/**
 * DECORADOR CONCRETO — Reemplaza todos los espacios por guiones bajos.
 *
 * Es el decorador más externo en EjemploDecorador, así que es el primero
 * en ejecutarse cuando alguien llama darFormato() desde afuera.
 * Pero como necesita el texto ya procesado por las capas interiores,
 * primero delega hacia adentro y luego aplica su transformación al resultado.
 *
 * Ejemplo: "!NOTLIM LAT EUQ ALOH\n____________________"
 *       →  "!NOTLIM_LAT_EUQ_ALOH\n____________________"
 *
 * Nota: el \n y los '_' del SubrayadoDecorador no tienen espacios,
 * así que solo los espacios entre palabras quedan afectados.
 */
public class RemplazarEspaciosDecorador extends TextoDecorador {

    public RemplazarEspaciosDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        // # texto.darFormato() dispara toda la cadena interior (Mayuscula → Reversa → Subrayado → Texto).
        // # .replace(" ", "_") actúa sobre el resultado final de esa cadena.
        return texto.darFormato().replace(" ", "_");
    }
}
