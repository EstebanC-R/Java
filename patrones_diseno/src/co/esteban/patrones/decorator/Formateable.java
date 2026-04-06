package co.esteban.patrones.decorator;

/**
 * PATRÓN DECORATOR — Interfaz base (el "contrato")
 *
 * Este es el tipo que une todo el patrón.
 * Tanto el objeto real (Texto) como todos los decoradores implementan
 * esta interfaz. Eso permite que los decoradores se apilen entre sí:
 * cada uno puede envolver a cualquier otro porque todos comparten el mismo tipo.
 *
 * Si esta interfaz no existiera, un decorador no podría recibir a otro
 * decorador como parámetro sin saber exactamente cuál es.
 */
public interface Formateable {
    // # El único método del contrato.
    // # Cada capa de la cadena lo implementa aplicando su propia transformación
    // # y luego delegando al objeto de adentro.
    String darFormato();
}
