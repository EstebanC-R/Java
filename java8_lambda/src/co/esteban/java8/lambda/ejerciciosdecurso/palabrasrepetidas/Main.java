package co.esteban.java8.lambda.ejerciciosdecurso.palabrasrepetidas;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ContarPalabra bucador = frase -> {

            Map<String, Integer> buscar = new HashMap<>();

            String[] palabras = frase.toLowerCase()
                    .replace(".", "")
                    .replace(",", "")
                    .split(" ");

            for(String palabra : palabras){
                if(buscar.containsKey(palabra)){
                    int max = buscar.get(palabra);
                    buscar.put(palabra, max + 1);
                } else {
                    buscar.put(palabra, 1);
                }
            }

            String palabraMasRepetida = "";
            int numeroDeRepeticiones = 0;

            for(Map.Entry<String, Integer> entry : buscar.entrySet()){
                if(entry.getValue() > numeroDeRepeticiones){
                    palabraMasRepetida = entry.getKey();
                    numeroDeRepeticiones = entry.getValue();
                }
            }

            Map<String, Integer> resultado = new HashMap<>();

            resultado.put(palabraMasRepetida, numeroDeRepeticiones);

            return resultado;
        };

        Map<String, Integer> resultado = bucador.conteo("Hola me llamo milton, vengo de una ciudad que se llama hola, y no me gusta que me llamen " +
                "milton porque pienso que soy imbécil, mejor llamame esteban. Si, mejor eso... Esteban");

        resultado.forEach((palabra, veces) -> System.out.println("La palabra más repetida es '" + palabra + "' con un número de veces de " + veces));
    }
}
