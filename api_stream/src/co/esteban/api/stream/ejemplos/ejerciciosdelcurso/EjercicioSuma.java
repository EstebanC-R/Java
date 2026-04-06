package co.esteban.api.stream.ejemplos.ejerciciosdelcurso;

import java.util.*;
import java.util.stream.Stream;


public class EjercicioSuma {
    public static void main(String[] args) {


        /*
            % Como desafió consiste en un arreglo de 100 elementos del 1 al
            % 100, del tipo int, utilizando el api stream se pide eliminar los
            % divisibles en 10, luego convertir los elementos restante del
            % flujo en tipo double y dividirlos en 2, para finalmente devolver
            % la suma total de todos ellos usando el operador terminal reduce.
            * El resultado debería ser 2250.0
        */

        int[] lista = new int[100];
        for(int i = 1; i <= 100; i++ ){
            lista[i -1] = i;
        }

        OptionalDouble sumaTotal = Arrays.stream(lista)
                .filter(n -> n % 10 != 0)
                .mapToDouble(n -> (double) n / 2)
                .reduce(Double::sum);


        System.out.println("El resultado es: " + sumaTotal);

    }
}
