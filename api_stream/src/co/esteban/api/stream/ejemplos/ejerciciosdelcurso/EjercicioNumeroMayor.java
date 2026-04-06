package co.esteban.api.stream.ejemplos.ejerciciosdelcurso;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.function.Function;

public class EjercicioNumeroMayor {
    public static void main(String[] args) {

        /*
            # El siguiente ejercicio es obtener el numero mayor de
            # un arreglo pero utilizando programación funcional,
            # implementando la expresión lambda Function<T,R>
            # (que viene predefinida) con el api stream y operador reduce.
        */

        Integer[] numeros = {1, 2, 3, 4, 5, 6, 12, 53, 0, 14};

        Function<Integer[], Integer> numMax = a -> Arrays.stream(a).reduce(0, (actual, num) -> actual > num ? actual : num);

        int resultado = numMax.apply(numeros);

        System.out.println("\nEl número maximo es: " + resultado);

    }
}
