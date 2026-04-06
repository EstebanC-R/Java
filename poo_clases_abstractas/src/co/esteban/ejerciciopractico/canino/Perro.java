package co.esteban.ejerciciopractico.canino;

public class Perro extends Canino{
    private int fuerzaMordida;

    public Perro(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float largoColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, largoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    public int getFuerzaMordida() {
        return fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El perro salvaje africano (" + nombreCientifico + ") caza en el " + habitat +
                " y muerde con una fuerza de " + fuerzaMordida + " psi.";
    }

    @Override
    public String dormir() {
        return "El perro salvaje africano descansa en madrigueras del " + habitat +
                " con pelaje de color " + color + ".";
    }

    @Override
    public String correr() {
        return "El perro salvaje africano corre en grupo mostrando sus colmillos de " +
                largoColmillos + " cm.";
    }

    @Override
    public String comunicarse() {
        return "El perro salvaje africano se comunica mediante chillidos y ladridos en el " + habitat + ".";
    }

    @Override
    public String toString() {
        return super.toString() + "\n- Fuerza de la Mordida (PSI Libras por pulgada cuadrada): " + fuerzaMordida;
    }
}
