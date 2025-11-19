public class EjemploStringInmutable {
    static void main() {
        // Aquí lo que es importante entender es que String es inmutable por lo que no se puede
        // modificar hasta crear una nueva instancia o variable.

        String curso = "Programación Java";
        String profesor = "Milton Esteban";

        String resultado = curso.concat(profesor);
        System.out.println("curso = " + curso);
        System.out.println("resultado = " + resultado);
        System.out.println(curso == resultado);
        
        // Esto es lambda o funciones flecha.
        // Curso es inmutable por lo que por más que se concatene no va a agregar a profesor.
        // Lo que se hace es, por otro lado, darle una variable en donde almacenar el nuevo resultado de la lambda.
        String resultado2 = curso.transform(c -> {
            return c + " con " + profesor;
        });

        System.out.println("curso = " + curso);
        System.out.println("resultado2 = " + resultado2);
        String resultado3 = resultado.replace("a", "A");

        System.out.println("resultado = " + resultado);
        System.out.println("resultado3 = " + resultado3);
    }
}
