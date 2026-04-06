package co.esteban.patrones.decorator;

import co.esteban.patrones.decorator.decorador.MayusculaDecorador;
import co.esteban.patrones.decorator.decorador.RemplazarEspaciosDecorador;
import co.esteban.patrones.decorator.decorador.ReversaDecorador;
import co.esteban.patrones.decorator.decorador.SubrayadoDecorador;

/**
 * CLIENTE del patrón Decorator.
 *
 * Aquí se construye la cadena de decoradores manualmente, capa por capa.
 * El orden importa: cada decorador envuelve al anterior, así que
 * la transformación más interna se ejecuta primero.
 *
 * Cadena construida (de adentro hacia afuera):
 *   Texto  →  Mayúscula  →  Reversa  →  Subrayado  →  RemplazarEspacios
 *
 * Cuando se llama remplazar.darFormato(), la ejecución viaja así:
 *   RemplazarEspacios → Subrayado → Reversa → Mayúscula → Texto (origen)
 *   ... y el resultado vuelve capa por capa aplicando cada transformación.
 *
 * Resultado final con "Hola que tal Milton!":
 *   !NOTLIM_LAT_EUQ_ALOH
 *   ____________________
 */
public class EjemploDecorador {
    public static void main(String[] args) {

        // [Capa 0] El objeto base. Solo guarda el texto original.
        Formateable texto = new Texto("Hola que tal Milton!");

        // [Capa 1] Envuelve a texto. Cuando se le pida darFormato(),
        // llamará a texto.darFormato() y convertirá el resultado a MAYÚSCULAS.
        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);

        // [Capa 2] Envuelve a mayuscula. Primero ejecuta mayuscula (que ejecuta texto),
        // luego invierte el resultado. "HOLA QUE TAL MILTON!" → "!NOTLIM LAT EUQ ALOH"
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);

        // [Capa 3] Envuelve a reversa. Agrega un '\n' y una línea de '_' del mismo largo.
        SubrayadoDecorador subrayar = new SubrayadoDecorador(reversa);

        // [Capa 4 - la más externa] Envuelve a subrayar. Reemplaza cada espacio por '_'.
        // Esta es la capa que el cliente invoca directamente.
        RemplazarEspaciosDecorador remplazar = new RemplazarEspaciosDecorador(subrayar);

        // Una sola llamada dispara toda la cadena hacia adentro y el resultado
        // vuelve transformado capa por capa hasta llegar aquí.
        System.out.println(remplazar.darFormato());
    }
}
