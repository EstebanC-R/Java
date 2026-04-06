package co.esteban.ejerciciopractico.canino;

public class Lobo extends Canino{
    private int numCamada;
    private String especieLobo;

    public Lobo(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float largoColmillos, int numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, largoColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    public int getNumCamada() {
        return numCamada;
    }

    public String getEspecieLobo() {
        return especieLobo;
    }

    @Override
    public String comer() {
        return "El lobo de especie " + especieLobo + " caza en el " + habitat +
                " junto a su camada de " + numCamada + " individuos.";
    }

    @Override
    public String dormir() {
        return "El lobo descansa en madrigueras del " + habitat +
                " con su pelaje de color " + color + ".";
    }

    @Override
    public String correr() {
        return "El lobo corre velozmente mostrando sus colmillos de " + largoColmillos +
                " cm y un cuerpo de " + peso + " kg.";
    }

    @Override
    public String comunicarse() {
        return "El lobo aúlla para comunicarse con su manada en el " + habitat + ".";
    }

    @Override
    public String toString() {
        return super.toString() + "\n- Número de Camada: " + numCamada +
                "\n- Especie de Lobo: " + especieLobo;
    }
}
