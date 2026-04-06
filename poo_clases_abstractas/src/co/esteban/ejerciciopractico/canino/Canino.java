package co.esteban.ejerciciopractico.canino;

import co.esteban.ejerciciopractico.mamifero.Mamifero;

abstract public class Canino extends Mamifero {
    protected String color;
    protected float largoColmillos;

    public Canino(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float largoColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.largoColmillos = largoColmillos;
    }

    public String getColor() {
        return color;
    }

    public float getLargoColmillos() {
        return largoColmillos;
    }

    @Override
    public String toString() {
        return super.toString() + "\n- Color: " + color +
                "\n- Largo Colmillos (cm): " + largoColmillos;
    }
}
