package co.esteban.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        // $ Recibe un argumento y devuelve un valor.
        Function<String, String> f1 = param -> "Hola que tal! " + param;
        String resultado = f1.apply("Milton");
        System.out.println(resultado);


        Function<String, String> f2 = String::toUpperCase;
        System.out.println(f2.apply("Milton"));

        // # Para resumir <p1, p2, d3>
        // # p1 = primer tipo de dato que recibe
        // # p2 = segundo tipo de dato que recibe
        // # d3 = tipo de dato que devuelve
        // #
        BiFunction<String, String, String> f3 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        String r2 = f3.apply("Milton", "Yony");
        System.out.println(r2);

        BiFunction<String, String, Integer> f4 = String::compareTo; // * (a, b) -> a.compareTo(b);
        System.out.println(f4.apply("Milton", "Milton"));

        BiFunction<String, String, String> f5 = String::concat; // * (a, b) -> a.concat(b);
        System.out.println(f5.apply("Milton", "Pepe"));
    }
}
