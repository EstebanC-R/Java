public class EjemploString {
    static void main() {

        // Ambas son las mismas solo qué java lo hace por detrás
        // creando una instancia automáticamente.
        String curso = "Programación Java";
        String curso2 = new String("Programación Java");

        // Aunque parezcan ser los mismos no lo son, ya que uno lo hace de forma
        // Implicíta y el otro de forma Explicíta.
        boolean esIgual = curso == curso2;
        System.out.println("curso == curso2 = " + esIgual);

        // Este solo compara el valor del String.
        esIgual = curso.equals(curso2);
        System.out.println("curso.equals(curso2) = " + esIgual);

        // Son los mismos objetos por lo que no se crea una nueva instancia, sino que la reutiliza,
        // siendo igual.
        String curso3 = "Programación Java";
        esIgual = curso == curso3;
        System.out.println("curso == curso3 = " + esIgual);
    }
}
