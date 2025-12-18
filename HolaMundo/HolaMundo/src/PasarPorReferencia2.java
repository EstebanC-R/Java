
class Persona {
    private String nombre;

    public void modificarNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public String getNombre(){
        return nombre;
    }
}

public class PasarPorReferencia2 {
    static void main() {
        Persona persona = new Persona();
        persona.modificarNombre("Milton");

        System.out.println("Iniciamos el método main\n");
        System.out.println("persona. = " + persona.getNombre());

        System.out.println("Antes de llamar al método test");
        test(persona);

        System.out.println("Después de llamar al método test");
        System.out.println("persona.getNombre() = " + persona.getNombre());

        System.out.println("Finaliza el método main con los datos de la persona modificados!");
    }

    public static void test(Persona persona){
        System.out.println("Iniciamos el método test");
        persona.modificarNombre("Pepe");
        System.out.println("Finaliza el método test");
    }
}
