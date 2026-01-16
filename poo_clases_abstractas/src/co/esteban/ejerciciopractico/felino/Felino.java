package co.esteban.ejerciciopractico.felino;

import co.esteban.ejerciciopractico.mamifero.Mamifero;

abstract public class Felino extends Mamifero {
    protected float largoGarras;
    protected int velocidad;

    public Felino(String habitat, float altura, float largo, float peso, String nombreCientifico, float largoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.largoGarras = largoGarras;
        this.velocidad = velocidad;
    }

    public float getLargoGarras() {
        return largoGarras;
    }

    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {
        return super.toString() + "\n- Largo Garras (cm): " + largoGarras +
                "\n- Velocidad (Km/h): " + velocidad;
    }
}
