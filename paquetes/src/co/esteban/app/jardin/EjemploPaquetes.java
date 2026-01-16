package co.esteban.app.jardin;

// % import co.esteban.app.hogar.Gato;
// % import co.esteban.app.hogar.Persona;


// ? Aquí lo que vemos es que basicamente estamos importando aboslutamente todo de el paquete hogar
import co.esteban.app.hogar.*;
import static co.esteban.app.hogar.Persona.saludar;
import static co.esteban.app.hogar.Persona.*;
import static co.esteban.app.hogar.ColorPelo.*;

public class EjemploPaquetes {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro perro = new Perro();

        p.setNombre("Milton");
        p.setApellido("Castaño");
        p.setColorPelo(COLORIN);
        perro.nombre = "Tom";
        perro.raza = "Golden Retriever";

        String jugando = perro.jugar(p);
        System.out.println(jugando);
        String saludo = saludar();
        System.out.println("saludo = " + saludo);
        String generoMasculino = GENERO_MASCULINO;
        String generoFemenino = GENERO_FEMENINO;

    }
}
