public class EjemploStringConcatenacion {
    static void main() {
        String curso = "Programación Java";
        String profesor = "Milton Esteban";

        String detalle = curso + " con el instructor " + profesor;
        System.out.println(detalle);

        int numeroA = 10;
        int numeroB = 5;

        // Al encontrar primero un String, pues directamente no suma los datos int,
        // por lo que hay que sumarlos dentro de un (paréntesis)
        System.out.println(detalle + (numeroA + numeroB));

        // Siguiendo la lógica, pues directamente este al empezar con un número,
        // lo que hace si es sumarlos y después concatenar el String.
        System.out.println(numeroA + numeroB + detalle);

        // Si se utiliza concat se puede ir anidando además la clase String es Inmutable
        String detalle2 = curso.concat(" con ").concat(profesor);
        System.out.println("detalle2 = " + detalle2);
    }
}
