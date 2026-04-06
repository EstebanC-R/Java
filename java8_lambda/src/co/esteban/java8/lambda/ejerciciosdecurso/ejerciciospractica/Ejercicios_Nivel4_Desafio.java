package co.esteban.java8.lambda.ejerciciosdecurso.ejerciciospractica;


import java.util.*;

// ! ============================================================================================================
// ! EJERCICIOS NIVEL 4 - DESAFÍO (Similares al ejercicio de palabras repetidas del curso)
// ! Objetivo: Problemas complejos que requieren combinar múltiples conceptos
// ! ============================================================================================================

public class Ejercicios_Nivel4_Desafio {

    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 4.1: ENCONTRAR PALABRA MÁS REPETIDA ===");
        ejercicio4_1();

        System.out.println("\n=== EJERCICIO 4.2: CONTAR VOCALES Y CONSONANTES ===");
        ejercicio4_2();

        System.out.println("\n=== EJERCICIO 4.3: TOP 3 PALABRAS MÁS FRECUENTES ===");
        // ejercicio4_3();

        System.out.println("\n=== EJERCICIO 4.4: AGRUPAR PALABRAS POR LONGITUD ===");
        // ejercicio4_4();

        System.out.println("\n=== EJERCICIO 4.5: ESTADÍSTICAS DE TEXTO COMPLETAS ===");
        // ejercicio4_5();
    }


    // ! --------------------------------------------------------------------------------------------------------
    // ! EJERCICIO 4.1: Encontrar la palabra MÁS REPETIDA (Similar al del curso)
    // ! --------------------------------------------------------------------------------------------------------
    // ! Este es IGUAL al ejercicio del curso que te costó trabajo
    // !
    // ! TODO: Implementa una lambda que:
    // ! 1. Reciba una frase
    // ! 2. Retorne un Map con UNA SOLA entrada: la palabra más repetida y cuántas veces aparece
    // !
    // ! ESTRATEGIA PASO A PASO:
    // ! A. Limpia la frase (quita puntos, comas, convierte a minúsculas)
    // ! B. Divide en palabras con split(" ")
    // ! C. Crea un HashMap para contar TODAS las palabras (como en ejercicio 3.1)
    // ! D. Encuentra cuál palabra tiene el máximo conteo:
    // !    - Crea variables: palabraMax y conteoMax
    // !    - Recorre el HashMap
    // !    - Si encuentras un conteo mayor, actualiza las variables
    // ! E. Retorna un Map con solo esa palabra y su conteo

    public static void ejercicio4_1() {
        @FunctionalInterface
        interface BuscadorPalabraMasRepetida {
            Map<String, Integer> buscar(String frase);
        }

        BuscadorPalabraMasRepetida buscador = frase -> {
            // PASO A: Limpiar la frase
            String fraseLimpia =  frase.toLowerCase()
                    .replace(",", "")
                    .replace(".", "")
                    .replace("!", "");

            // PASO B: Dividir en palabras
            String[] palabras = fraseLimpia.split(" ");

            // PASO C: Contar TODAS las palabras (igual que ejercicio 3.1)
            Map<String, Integer> contadorTodas = new HashMap<>();
            // ?  TODO: Recorre 'palabras' y cuenta cada una en el HashMap

            for(String palabra : palabras){
                if(contadorTodas.containsKey(palabra)){
                    int contadorActual = contadorTodas.get(palabra);
                    contadorTodas.put(palabra, contadorActual + 1);
                }else {
                    contadorTodas.put(palabra, 1);
                }
            }

            // PASO D: Encontrar la palabra con mayor conteo
            String palabraMasRepetida = null;
            int maxConteo = 0;

            // ? TODO: Recorre el HashMap 'contadorTodas'
            for (Map.Entry<String, Integer> entry : contadorTodas.entrySet()) {
                if (entry.getValue() > maxConteo) {
                    maxConteo = entry.getValue();
                    palabraMasRepetida = entry.getKey();
                }
            }

            // PASO E: Crear y retornar map con solo esa palabra
            Map<String, Integer> resultado = new HashMap<>();
            resultado.put(palabraMasRepetida, maxConteo);

            return resultado;
        };

        String frase = "hola mundo hola java hola programacion java hola";
        Map<String, Integer> resultado = buscador.buscar(frase);

        resultado.forEach((palabra, veces) ->
                System.out.println("La palabra '" + palabra + "' se repite " + veces + " veces"));

        // Resultado esperado:
        // La palabra 'hola' se repite 4 veces
    }


    // ! --------------------------------------------------------------------------------------------------------
    // ! EJERCICIO 4.2: Contar vocales y consonantes por separado
    // ! --------------------------------------------------------------------------------------------------------
    // ! TODO: Crea una lambda que reciba un texto y retorne un Map con:
    // ! - "vocales" -> Map<Character, Integer> con cada vocal y su conteo
    // ! - "consonantes" -> Map<Character, Integer> con cada consonante y su conteo
    // !
    // ! PISTAS:
    // ! - Usa Map<String, Map<Character, Integer>> como tipo de retorno
    // ! - Define un String con las vocales: "aeiou"
    // ! - Recorre cada carácter del texto
    // ! - Verifica si es vocal o consonante (y que sea letra)
    // ! - Character.isLetter(c) te dice si es una letra

    public static void ejercicio4_2() {
        @FunctionalInterface
        interface ContadorVocalesConsonantes {
            Map<String, Map<Character, Integer>> contar(String texto);
        }

        ContadorVocalesConsonantes contador = texto -> {
            Map<String, Map<Character, Integer>> resultado = new HashMap<>();

            // Inicializar los dos sub-maps
            resultado.put("vocales", new HashMap<>());
            resultado.put("consonantes", new HashMap<>());

            String vocales = "aeiouAEIOU";

            // ? TODO: Recorre cada carácter del texto
            for (char c : texto.toCharArray()) {
                 // Si es letra
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);

                    if (vocales.indexOf(c) != -1) {
                        // Es vocal - agrégala al map de vocales
                        Map<Character, Integer> mapVocales = resultado.get("vocales");
                        if(mapVocales.containsKey(c)){
                            mapVocales.put(c, mapVocales.get(c) + 1);
                        }else {
                            mapVocales.put(c, 1);
                        }
                    } else {
                        Map<Character, Integer> mapConsonantes = resultado.get("consonantes");
                        if(mapConsonantes.containsKey(c)){
                            mapConsonantes.put(c, mapConsonantes.get(c) + 1);
                        }else {
                            mapConsonantes.put(c, 1);
                        }
                    }
                }
            }

            return resultado;
        };

        String texto = "Hola mundo de Java";
        Map<String, Map<Character, Integer>> resultado = contador.contar(texto);

        System.out.println("Vocales:");
        resultado.get("vocales").forEach((letra, cantidad) ->
                System.out.println("  " + letra + " -> " + cantidad));

        System.out.println("Consonantes:");
        resultado.get("consonantes").forEach((letra, cantidad) ->
                System.out.println("  " + letra + " -> " + cantidad));
    }


    // * --------------------------------------------------------------------------------------------------------
    // * EJERCICIO 4.3: Top 3 palabras más frecuentes
    // * --------------------------------------------------------------------------------------------------------
    // * TODO: Encuentra las 3 palabras más repetidas (no solo la primera)
    // * Retorna una List<Map.Entry<String, Integer>> ordenada de mayor a menor
    // *
    // * ESTRATEGIA:
    // * 1. Cuenta todas las palabras (como en ejercicio 3.1)
    // * 2. Convierte el HashMap a una List de sus entries: new ArrayList<>(map.entrySet())
    // * 3. Ordena la lista usando Collections.sort() con un Comparator
    // * 4. Toma solo los primeros 3 elementos

    public static void ejercicio4_3() {
        @FunctionalInterface
        interface BuscadorTop3 {
            List<Map.Entry<String, Integer>> buscar(String frase);
        }

        BuscadorTop3 buscador = frase -> {
            // PASO 1: Contar todas las palabras
            Map<String, Integer> conteo = new HashMap<>();
            String[] palabras = frase.toLowerCase()
                    .replace(".", "")
                    .replace(",", "")
                    .split(" ");

            // TODO: Cuenta cada palabra en el HashMap

            for(String palabra : palabras){
                if(conteo.containsKey(palabra)){
                    conteo.put(palabra, conteo.get(palabra) + 1);
                } else {
                    conteo.put(palabra, 1);
                }
            }

            // PASO 2: Convertir a lista
            List<Map.Entry<String, Integer>> lista = new ArrayList<>(conteo.entrySet());

            // PASO 3: Ordenar de mayor a menor
            Collections.sort(lista, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            // El e2 - e1 es para orden descendente (mayor a menor)

            // PASO 4: Tomar solo los primeros 3
            List<Map.Entry<String, Integer>> top3 = new ArrayList<>();
            // for (int i = 0; i < 3 && i < lista.size(); i++) {
            //     top3.add(lista.get(i));
            // }

            return top3;
        };

        String frase = "java es genial java es poderoso java es moderno python es tambien genial";
        List<Map.Entry<String, Integer>> top3 = buscador.buscar(frase);

        System.out.println("Top 3 palabras más frecuentes:");
        for (int i = 0; i < top3.size(); i++) {
            Map.Entry<String, Integer> entry = top3.get(i);
            System.out.println((i+1) + ". " + entry.getKey() + " -> " + entry.getValue() + " veces");
        }
    }


    // * --------------------------------------------------------------------------------------------------------
    // * EJERCICIO 4.4: Agrupar palabras por su longitud
    // * --------------------------------------------------------------------------------------------------------
    // * TODO: Retorna un Map donde:
    // * - Clave: longitud de la palabra (Integer)
    // * - Valor: List de todas las palabras con esa longitud
    // *
    // * Ejemplo: "hola adios si" -> {4: [hola], 5: [adios], 2: [si]}

    public static void ejercicio4_4() {
        @FunctionalInterface
        interface AgrupadorPorLongitud {
            Map<Integer, List<String>> agrupar(String frase);
        }

        AgrupadorPorLongitud agrupador = frase -> {
            Map<Integer, List<String>> resultado = new HashMap<>();

            String[] palabras = frase.split(" ");

            for (String palabra : palabras) {
                int longitud = palabra.length();

                // TODO: Si la longitud no está en el map, crea una lista nueva
                // if (!resultado.containsKey(longitud)) {
                //     resultado.put(longitud, new ArrayList<>());
                // }

                // Agrega la palabra a la lista correspondiente
                // resultado.get(longitud).add(palabra);
            }

            return resultado;
        };

        String frase = "Java es un lenguaje muy potente y moderno";
        Map<Integer, List<String>> resultado = agrupador.agrupar(frase);

        resultado.forEach((longitud, palabras) ->
                System.out.println("Longitud " + longitud + ": " + palabras));
    }


    // # --------------------------------------------------------------------------------------------------------
    // # EJERCICIO 4.5: DESAFÍO FINAL - Estadísticas completas de texto
    // # --------------------------------------------------------------------------------------------------------
    // # Este es el más completo y desafiante
    // #
    // # TODO: Crea una lambda que analice un texto y retorne UN SOLO Map con:
    // # - "totalPalabras" -> cantidad total de palabras
    // # - "palabraUnica" -> cantidad de palabras únicas (distintas)
    // # - "palabraMasLarga" -> la palabra más larga
    // # - "palabraMasRepetida" -> la palabra que más se repite
    // # - "promedioLongitud" -> promedio de longitud de palabras
    // #
    // # ESTE EJERCICIO COMBINA TODO LO QUE HAS APRENDIDO

    public static void ejercicio4_5() {
        @FunctionalInterface
        interface AnalizadorTexto {
            Map<String, Object> analizar(String texto);
        }

        AnalizadorTexto analizador = texto -> {
            Map<String, Object> estadisticas = new HashMap<>();

            // Preparar el texto
            String textoLimpio = texto.toLowerCase()
                    .replace(".", "")
                    .replace(",", "")
                    .replace("!", "")
                    .replace("?", "");

            String[] palabras = textoLimpio.split(" ");

            // TODO 1: Total de palabras
            // estadisticas.put("totalPalabras", ???);

            // TODO 2: Contar frecuencia de cada palabra
            Map<String, Integer> frecuencias = new HashMap<>();
            // ... (código para contar)

            // TODO 3: Palabras únicas (tamaño del HashMap)
            // estadisticas.put("palabrasUnicas", ???);

            // TODO 4: Palabra más larga
            String masLarga = "";
            // ... (recorrer y comparar longitudes)
            // estadisticas.put("palabraMasLarga", masLarga);

            // TODO 5: Palabra más repetida
            String masRepetida = "";
            int maxFrecuencia = 0;
            // ... (recorrer el HashMap de frecuencias)
            // estadisticas.put("palabraMasRepetida", masRepetida);

            // TODO 6: Promedio de longitud
            int sumaLongitudes = 0;
            // ... (sumar todas las longitudes y dividir)
            // double promedio = (double) sumaLongitudes / palabras.length;
            // estadisticas.put("promedioLongitud", promedio);

            return estadisticas;
        };

        String texto = "Java es genial. Java es poderoso y Java es moderno. " +
                "La programacion en Java es muy divertida!";

        Map<String, Object> stats = analizador.analizar(texto);

        System.out.println("=== ESTADÍSTICAS DEL TEXTO ===");
        System.out.println("Total de palabras: " + stats.get("totalPalabras"));
        System.out.println("Palabras únicas: " + stats.get("palabrasUnicas"));
        System.out.println("Palabra más larga: " + stats.get("palabraMasLarga"));
        System.out.println("Palabra más repetida: " + stats.get("palabraMasRepetida"));
        System.out.println("Promedio de longitud: " + stats.get("promedioLongitud"));
    }
}