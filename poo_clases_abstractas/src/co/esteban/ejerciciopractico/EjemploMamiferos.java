package co.esteban.ejerciciopractico;

import co.esteban.ejerciciopractico.canino.Canino;
import co.esteban.ejerciciopractico.canino.Lobo;
import co.esteban.ejerciciopractico.canino.Perro;
import co.esteban.ejerciciopractico.felino.Felino;
import co.esteban.ejerciciopractico.felino.Guepardo;
import co.esteban.ejerciciopractico.felino.Leon;
import co.esteban.ejerciciopractico.felino.Tigre;
import co.esteban.ejerciciopractico.mamifero.Mamifero;

public class EjemploMamiferos {
    public static void main(String[] args) {
        Mamifero[] mamifero = new Mamifero[5];

        Mamifero leon = new Leon(
                "Sabana",
                120,
                210,
                190,
                "Panthera leo",
                3,
                80,
                30,
                170
        );

        Mamifero tigre = new Tigre(
                "Sureste de Rusia",
                110,
                320,
                300,
                "Panthera tigris",
                10,
                65,
                "Tigre siberiano"
        );

        Mamifero guepardo = new Guepardo(
                "Sabana africana",
                75,
                150,
                72,
                "Acinonyx jubatus",
                4,
                120
        );

        Mamifero lobo = new Lobo(
                "Bosques templados",
                80,
                120,
                45,
                "Canis lupus",
                "Gris",
                6,
                7,
                "Lobo gris"
        );

        Mamifero perro = new Perro(
                "Sabana agricana",
                75,
                100,
                30,
                "Lycaon pictus",
                "moteado, marrón y negro",
                3.5f,
                142
        );

        mamifero[0] = leon;
        mamifero[1] = tigre;
        mamifero[2] = guepardo;
        mamifero[3] = lobo;
        mamifero[4] = perro;

        for(Mamifero animal : mamifero){
            if(animal != null){
                System.out.println("\n------------ " + animal.getClass().getSimpleName() + " ------------");
                System.out.println(animal);
            }
        }
    }
}
