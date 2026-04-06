package co.esteban.java8.lambda.ejerciciosdecurso.ejerciciospractica;

import java.util.*;
import java.util.function.*;

// ! ============================================================================================================
// ! EJERCICIOS NIVEL 3 - AVANZADO (Similar a ejercicios del curso)
// ! Objetivo: Trabajar con HashMap, contadores, y problemas más complejos
// ! ============================================================================================================

public class Ejercicios_Nivel3_Avanzado {

    public static void main(String[] args) {

        System.out.println("=== EJERCICIO 3.1: CONTAR FRECUENCIA DE PALABRAS ===");
        ejercicio3_1();

        System.out.println("\n=== EJERCICIO 3.2: AGRUPAR NÚMEROS PARES E IMPARES ===");
        ejercicio3_2();

        System.out.println("\n=== EJERCICIO 3.3: PALABRA MÁS LARGA ===");
        ejercicio3_3();

        System.out.println("\n=== EJERCICIO 3.4: AGRUPAR PERSONAS POR EDAD ===");
        ejercicio3_4();

        System.out.println("\n=== EJERCICIO 3.5: INVERTIR UN MAP ===");
        ejercicio3_5();
    }


    // # --------------------------------------------------------------------------------------------------------
    // # EJERCICIO 3.1: Contar frecuencia de cada palabra en una frase
    // # --------------------------------------------------------------------------------------------------------
    // # TODO: Completa la lambda que recibe una frase y retorna un Map<String, Integer>
    // # donde la clave es cada palabra y el valor es cuántas veces aparece
    // #
    // # PASOS A SEGUIR:
    // # 1. Limpia la frase: quita puntos, comas, conviértela a minúsculas
    // # 2. Divide la frase en palabras con .split(" ")
    // # 3. Crea un HashMap vacío
    // # 4. Recorre el arreglo de palabras
    // # 5. Para cada palabra, verifica si ya está en el map:
    // #    - Si está: incrementa su contador
    // #    - Si no está: agrégala con valor 1
    // # 6. Retorna el map

    public static void ejercicio3_1() {
        // ? Interfaz funcional personalizada
        @FunctionalInterface
        interface ContadorPalabras {
            Map<String, Integer> contar(String frase);
        }

        ContadorPalabras contador = frase -> {
            // ? TODO: Implementa aquí la lógica
            Map<String, Integer> resultado = new HashMap<>();

            // ? Paso 1: Limpiar y preparar la frase
            String fraseLimpia = frase.toLowerCase().replace(",", "")
                    .replace(".", "").replace("!", "");

            // ? Paso 2: Dividir en palabras
            String[] palabras = fraseLimpia.split(" ");

            // ? Paso 3 y 4: Recorrer y contar
            for (String palabra : palabras) {
                 // Si la palabra ya existe en el map
                if (resultado.containsKey(palabra)) {
                    // Incrementa el contador
                    int contadorActual = resultado.get(palabra);
                    resultado.put(palabra, contadorActual + 1);
                } else {
                     // Agrega la palabra con valor 1
                    resultado.put(palabra, 1);
                }
            }

            return resultado;
        };

        Map<String, Integer> resultado = contador.contar("hola mundo, hola java. Java es genial, java y hola!");
        resultado.forEach((palabra, veces) -> System.out.println(palabra + " -> " + veces));

        // Resultado esperado:
        // hola -> 3
        // mundo -> 1
        // java -> 3
        // es -> 1
        // genial -> 1
        // y -> 1
    }


    // # --------------------------------------------------------------------------------------------------------
    // # EJERCICIO 3.2: Agrupar números en pares e impares
    // # --------------------------------------------------------------------------------------------------------
    // # TODO: Completa la lambda que recibe una lista de números y retorna un Map
    // # con clave "pares" que contenga todos los pares, e "impares" con todos los impares
    // #
    // # PASOS:
    // # 1. Crea un HashMap con dos claves: "pares" e "impares"
    // # 2. Inicializa cada clave con una ArrayList vacía
    // # 3. Recorre la lista de números
    // # 4. Si el número es par, agrégalo a la lista de "pares"
    // # 5. Si es impar, agrégalo a la lista de "impares"
    // # 6. Retorna el map

    public static void ejercicio3_2() {
        @FunctionalInterface
        interface AgrupadorNumeros {
            Map<String, List<Integer>> agrupar(List<Integer> numeros);
        }

        AgrupadorNumeros agrupador = numeros -> {
            // ? TODO: Implementa aquí
            Map<String, List<Integer>> resultado = new HashMap<>();

            // Inicializar las listas
            resultado.put("pares", new ArrayList<>());
            resultado.put("impares", new ArrayList<>());

            // Recorrer y clasificar
            for (Integer num : numeros) {
                if (num % 2 == 0) {
                    resultado.get("pares").add(num);
                } else {
                    resultado.get("impares").add(num);
                }
            }

            return resultado;
        };

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, List<Integer>> resultado = agrupador.agrupar(numeros);

        System.out.println("Pares: " + resultado.get("pares"));
        System.out.println("Impares: " + resultado.get("impares"));

        // Resultado esperado:
        // Pares: [2, 4, 6, 8, 10]
        // Impares: [1, 3, 5, 7, 9]
    }


    // # --------------------------------------------------------------------------------------------------------
    // # EJERCICIO 3.3: Encontrar la palabra más larga
    // # --------------------------------------------------------------------------------------------------------
    // # TODO: Completa la lambda que recibe una frase y retorna un Map con:
    // # - clave: la palabra más larga
    // # - valor: su longitud
    // #
    // # PASOS:
    // # 1. Divide la frase en palabras
    // # 2. Crea variables para rastrear la palabra más larga y su longitud
    // # 3. Recorre las palabras
    // # 4. Si encuentras una palabra más larga, actualiza tus variables
    // # 5. Crea y retorna un Map con la palabra y su longitud

    public static void ejercicio3_3() {
        @FunctionalInterface
        interface BuscadorPalabraLarga {
            Map<String, Integer> buscar(String frase);
        }

        BuscadorPalabraLarga buscador = frase -> {
            // TODO: Implementa aquí
            String[] palabras = frase.split(" ");

            String palabraMasLarga = "";
            int longitudMaxima = 0;

            for(String p : palabras){
                if(p.length() > longitudMaxima){
                    palabraMasLarga = p;
                    longitudMaxima = p.length();
                }
            }

            Map<String, Integer> resultado = new HashMap<>();
            resultado.put(palabraMasLarga, longitudMaxima);

            return resultado;
        };

        Map<String, Integer> resultado = buscador.buscar("Java es un lenguaje de programacion poderoso");
        resultado.forEach((palabra, longitud) ->
                System.out.println("Palabra más larga: '" + palabra + "' con " + longitud + " caracteres"));

        // Resultado esperado:
        // Palabra más larga: 'programacion' con 12 caracteres
    }


    // % --------------------------------------------------------------------------------------------------------
    // % EJERCICIO 3.4: Agrupar personas por rango de edad
    // % --------------------------------------------------------------------------------------------------------
    // % TODO: Completa la lambda que agrupa personas en categorías según su edad:
    // % - "menores" (0-17)
    // % - "adultos" (18-64)
    // % - "mayores" (65+)
    // %
    // % PASOS:
    // % 1. Crea un Map con las tres claves, cada una con una lista vacía
    // % 2. Recorre la lista de edades
    // % 3. Según la edad, agrégala a la categoría correspondiente

    public static void ejercicio3_4() {
        @FunctionalInterface
        interface AgrupadorEdades {
            Map<String, List<Integer>> agrupar(List<Integer> edades);
        }

        AgrupadorEdades agrupador = edades -> {
            Map<String, List<Integer>> resultado = new HashMap<>();
            resultado.put("menores", new ArrayList<>());
            resultado.put("adultos", new ArrayList<>());
            resultado.put("mayores", new ArrayList<>());

            // ? TODO: Completa la lógica de agrupación
            for (Integer edad : edades) {
                if (edad < 18) {
                    resultado.get("menores").add(edad);
                } else if (edad < 65) {
                    resultado.get("adultos").add(edad);
                } else {
                    resultado.get("mayores").add(edad);
                }
            }

            return resultado;
        };

        List<Integer> edades = Arrays.asList(5, 12, 18, 25, 30, 45, 65, 70, 80, 15, 60);
        Map<String, List<Integer>> resultado = agrupador.agrupar(edades);

        resultado.forEach((categoria, lista) ->
                System.out.println(categoria + ": " + lista));

        // Resultado esperado:
        // menores: [5, 12, 15]
        // adultos: [18, 25, 30, 45, 60]
        // mayores: [65, 70, 80]
    }


    // % --------------------------------------------------------------------------------------------------------
    // % EJERCICIO 3.5: Invertir un Map (clave-valor se convierte en valor-clave)
    // % --------------------------------------------------------------------------------------------------------
    // % TODO: Completa la lambda que invierte un Map
    // % Si el original es: {"uno" -> 1, "dos" -> 2}
    // % El invertido es: {1 -> "uno", 2 -> "dos"}
    // %
    // % PASOS:
    // % 1. Crea un nuevo HashMap vacío
    // % 2. Recorre el map original usando .forEach o un for
    // % 3. Por cada entrada, pon el valor como clave y la clave como valor

    public static void ejercicio3_5() {
        @FunctionalInterface
        interface InversorMap {
            Map<Integer, String> invertir(Map<String, Integer> original);
        }

        InversorMap inversor = original -> {
            Map<Integer, String> invertido = new HashMap<>();

            // % TODO: Invierte el map
            // Opción 1: Usando forEach con lambda
            original.forEach((clave, valor) -> {
                invertido.put(valor, clave);
            });

            // % Opción 2: Usando for tradicional Map.Entry<String, Integer>
            /*for (Map.Entry<String, Integer> entry : original.entrySet()) {
                invertido.put(entry.getValue(), entry.getKey());
            }*/

            return invertido;
        };

        Map<String, Integer> original = new HashMap<>();
        original.put("uno", 1);
        original.put("dos", 2);
        original.put("tres", 3);

        System.out.println("Original: " + original);
        Map<Integer, String> invertido = inversor.invertir(original);
        System.out.println("Invertido: " + invertido);

        // Resultado esperado:
        // Original: {uno=1, dos=2, tres=3}
        // Invertido: {1=uno, 2=dos, 3=tres}
    }
}