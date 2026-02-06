package co.esteban.java8.lambda.ejerciciosdecurso.eliminarcomaspuntosyespacios;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class EliminarEspaciosComasYPuntos {

    public static void main(String[] args) {
        BiFunction<String, List<Character>, String> quitarComasYEspacios = (a, b) -> {

            for(Character c : b){
                a = a.replace(c.toString(), "");
            }

            return a.toUpperCase();
        };

        List<Character> condicion = Arrays.asList(',', ' ', '.', '(', 'T', 't', 'm');

        String r = quitarComasYEspacios.apply(",,,.,.,.,.,.,.,.,,         Milton ....,,, ", condicion);

        System.out.println(r);
    }
}
