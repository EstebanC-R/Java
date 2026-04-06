package co.esteban.app.hogar;

import co.esteban.app.jardin.Perro;
import static co.esteban.app.hogar.Persona.saludar;


public class EjemploHogar {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro perro = new Perro();
        String saludo = saludar();
    }
}
