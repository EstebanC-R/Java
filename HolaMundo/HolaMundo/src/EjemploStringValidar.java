public class EjemploStringValidar {
    public static void main(String[] args) {
        String curso = null;

        boolean esNulo = curso == null;
        System.out.println("esNulo = " + esNulo);

        if(esNulo){
            curso = "Programación Java";
        }

        boolean esVacio = curso.length() == 0;
        System.out.println("esVacio = " + esVacio);

        if(!esVacio){
            System.out.println(curso.toUpperCase());
            System.out.println("Bienvenido al curso ".concat(curso));
        }

        boolean esVacio2 = curso.isEmpty();
        System.out.println("esVacio2 = " + esVacio2);

        if(!esVacio2){
            System.out.println(curso.toUpperCase());
            System.out.println("Bienvenido al curso ".concat(curso));
        }
        
        boolean esBlanco = curso.isBlank();
        System.out.println("esBlanco = " + esBlanco);

        if(!esBlanco){
            System.out.println(curso.toUpperCase());
            System.out.println("Bienvenido al curso ".concat(curso));
        }

        // con + concatena el null, pero con concat se cae la app debido a que no hay nada que concatenar.
        //System.out.println("Bienvenido al curso " + curso);
        //System.out.println("Bienvenido al curso ".concat(curso));

    }
}
