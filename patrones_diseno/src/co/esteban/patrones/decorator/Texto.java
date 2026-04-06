package co.esteban.patrones.decorator;

/**
 * COMPONENTE CONCRETO — El objeto base que se va a decorar.
 *
 * Esta es la capa más interna de la cebolla.
 * No sabe que existen los decoradores. Solo guarda el texto original
 * y lo devuelve tal cual cuando alguien llama darFormato().
 *
 * Cuando los decoradores se apilan encima, eventualmente todos terminan
 * llamando a este darFormato() para obtener el texto de origen.
 */
public class Texto implements Formateable {

    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    // # Sin transformaciones. Devuelve el texto en su estado original.
    // # Este es el punto de partida de toda la cadena de decoradores.
    @Override
    public String darFormato() {
        return getTexto();
    }
}
