package co.esteban.java8.lambda.ejerciciosdecurso.ejerciciospractica;

import co.esteban.java8.lambda.ejerciciosdecurso.ejerciciospractica.modelo.Usuario;

import java.util.*;
import java.util.function.*;

// ! ============================================================================================================
// ! EJERCICIOS NIVEL 2 - INTERMEDIO
// ! Objetivo: Usar lambdas con listas y escenarios más realistas
// ! ============================================================================================================

public class Ejercicios_Nivel2_Intermedio {
    public static void main(String[] args) {

        // # EJERCICIO 2.1: Imprimir todos los elementos de una lista
        // # TODO: Usa forEach con una lambda para imprimir cada nombre
        List<String> nombres = Arrays.asList("Ana", "Carlos", "Beatriz", "David");
        System.out.println("- Ejercicio 1: ");
        nombres.forEach(System.out::println); // Completa con tu lambda


        // # EJERCICIO 2.2: Filtrar números pares de una lista
        // # TODO: Usa removeIf con un Predicate para quitar los números impares
        // # Pista: removeIf elimina los elementos que cumplen la condición
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        numeros.removeIf(num -> num % 2 != 0); // Quita los impares
        System.out.println("- Ejercicio 2: " + numeros); // [2, 4, 6, 8, 10]


        // # EJERCICIO 2.3: Convertir una lista de strings a mayúsculas
        // # TODO: Usa replaceAll con una Function para convertir cada string
        List<String> palabras = new ArrayList<>(Arrays.asList("hola", "mundo", "java"));

        palabras.replaceAll(a -> a.toUpperCase());
        System.out.println("- Ejercicio 3: " + palabras); // [HOLA, MUNDO, JAVA]


        // % EJERCICIO 2.4: Crear objetos con Supplier
        // % TODO: Crea una lista de 5 ArrayLists vacíos usando un Supplier
        // % Pista: Usa un ciclo for y llama al supplier.get() 5 veces
        Supplier<List<String>> crearLista = ArrayList::new; // Supplier que retorna un nuevo ArrayList

        List<List<String>> listas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listas.add( crearLista.get() );
        }

        System.out.println("- Ejercicio 4: Creadas " + listas.size() + " listas");


        // % EJERCICIO 2.5: Procesar lista de edades
        // % TODO: Usando forEach, imprime solo las edades mayores a 18
        System.out.println("- Ejercicio 5: ");
        List<Integer> edades = Arrays.asList(15, 22, 17, 30, 12, 25, 18);

        edades.forEach( a -> {
            if(a > 18) {
                System.out.println("    " + a);
            };
        }); // Solo imprime las mayores a 18


        // % EJERCICIO 2.6: Modificar objetos con BiConsumer
        // % TODO: Crea una lista de usuarios y asigna nombres usando BiConsumer
        System.out.println("- Ejercicio 6: ");
        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario(), new Usuario());
        List<String> nombresUsuarios = Arrays.asList("Pedro", "María", "Juan");

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre; // Usa Usuario::setNombre

        for (int i = 0; i < usuarios.size(); i++) {
            asignarNombre.accept( usuarios.get(i), nombresUsuarios.get(i) );
        }

        usuarios.forEach(u -> System.out.println("    - " + u.getNombre()));


        // * EJERCICIO 2.7: Calcular total con acumulador
        // * TODO: Suma todos los precios usando un ciclo y una BiFunction
        List<Double> precios = Arrays.asList(10.5, 20.0, 15.75, 8.25);

        BiFunction<Double, Double, Double> sumar = Double::sum; // (a, b) -> a + b

        double total = 0.0;
        for (Double precio : precios) {
            total = sumar.apply( total, precio );
        }
        System.out.println("- Ejercicio 7: Total: " + total);


        // * EJERCICIO 2.8: Validar todos los elementos
        // * TODO: Verifica si TODOS los números son positivos usando Predicate
        List<Integer> numerosTest = Arrays.asList(1, 5, 8, 12, 3);

        Predicate<Integer> esPositivo = a -> a > 0;

        boolean todosSonPositivos = true;

        for (Integer num : numerosTest) {
            if (!esPositivo.test(num)) {
                todosSonPositivos = false;
                break;
            }
        }
        System.out.println("- Ejercicio 8: ¿Todos positivos? " + todosSonPositivos);


        // * EJERCICIO 2.9: Transformar lista de enteros a strings
        // * TODO: Convierte cada número a string con prefijo "Número: "
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> resultado = new ArrayList<>();

        Function<Integer, String> convertir = num -> "Número: " + num; // num -> "Número: " + num

        for (Integer num : nums) {
            resultado.add( convertir.apply(num) );
        }
        System.out.println("- Ejercicio 9: " + resultado);


        // * EJERCICIO 2.10: Contar elementos que cumplen condición
        // * TODO: Cuenta cuántos nombres tienen más de 5 letras
        List<String> nombresTest = Arrays.asList("Ana", "Roberto", "Carlos", "Fe", "Alejandra");

        Predicate<String> tieneMasDe5Letras = a -> a.length() > 5;

        int contador = 0;

        for (String nombre : nombresTest) {
            if (tieneMasDe5Letras.test(nombre)) {
                contador++;
            }
        }
        System.out.println("- Ejercicio 10:\n\tNombres con más de 5 letras: " + contador);
    }
}
