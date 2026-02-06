package co.esteban.java8.lambda.ejerciciosdecurso.ejerciciospractica;

import java.util.function.*;

// ! ============================================================================================================
// ! EJERCICIOS NIVEL 1 - BÁSICO
// ! Objetivo: Familiarizarte con la sintaxis y las interfaces funcionales básicas
// ! ============================================================================================================

public class Ejercicios_Nivel1_Basico {

    public static void main(String[] args) {

        // ? EJERCICIO 1.1: Consumer - Imprimir un mensaje personalizado
        // ? TODO: Crea un Consumer que reciba un nombre y lo imprima con el formato: "Hola, [nombre]!"
        Consumer<String> saludar = nombre -> {
            System.out.println("\n- Ejercicio 1: Hola, " + nombre + "!");
        };

        saludar.accept("Milton"); // Debería imprimir: Hola, Milton!


        // ? EJERCICIO 1.2: Predicate - Validar si un número es par
        // ? TODO: Crea un Predicate que retorne true si el número es par
        Predicate<Integer> esPar = numero -> {
            if(numero % 2 == 0){
                return true;
            }
            return false;
        };

        System.out.println("- Ejercicio 2: " + esPar.test(4));  // true
        System.out.println("- Ejercicio 2: " + esPar.test(7));  // false


        // ? EJERCICIO 1.3: Function - Convertir string a su longitud
        // ? TODO: Crea una Function que reciba un String y retorne su longitud (Integer)
        Function<String, Integer> obtenerLongitud = String::length;

        System.out.println("- Ejercicio 3: " + obtenerLongitud.apply("Hola buenas tardes!")); // 19 contando espacios


        // ? EJERCICIO 1.4: Supplier - Generar un número aleatorio
        // ? TODO: Crea un Supplier que retorne un número aleatorio entre 1 y 100
        // ? Pista: (int)(Math.random() * 100) + 1
        Supplier<Integer> numeroAleatorio = () -> (int)(Math.random() * 100) + 1;

        System.out.println("- Ejercicio 4: " + numeroAleatorio.get());


        // ? EJERCICIO 1.5: BiFunction - Sumar dos números
        // ? TODO: Crea una BiFunction que sume dos Integers y retorne el resultado
        BiFunction<Integer, Integer, Integer> sumar = Integer::sum;

        System.out.println("- Ejercicio 5: " + sumar.apply(5, 3)); // 8


        // ? EJERCICIO 1.6: BiPredicate - Verificar si dos strings son iguales (ignorar mayúsculas)
        // ? TODO: Crea un BiPredicate que compare dos strings ignorando mayúsculas
        // ? Pista: usa equalsIgnoreCase
        BiPredicate<String, String> sonIguales = (a,b) -> a.equalsIgnoreCase(b.toLowerCase());

        System.out.println("- Ejercicio 6: " + sonIguales.test("Hola", "hola")); // true
        System.out.println("- Ejercicio 6: " + sonIguales.test("Hola", "adios")); // false


        // $ EJERCICIO 1.7: BiConsumer - Imprimir dos valores
        // $ TODO: Crea un BiConsumer que reciba un nombre y edad, e imprima: "[nombre] tiene [edad] años"
        BiConsumer<String, Integer> imprimirPersona = (nombre, edad) -> System.out.println(nombre + " tiene " + edad + " años.");

        imprimirPersona.accept("- Ejercicio 7: " + "Ana", 25); // Ana tiene 25 años


        // $ EJERCICIO 1.8: Function con método de referencia
        // $ TODO: Crea una Function que convierta un string a mayúsculas usando method reference
        Function<String, String> aMayusculas = String::toUpperCase; // Usa String::toUpperCase

        System.out.println("- Ejercicio 8: " + aMayusculas.apply("hola mundo")); // HOLA MUNDO


        // $ EJERCICIO 1.9: Predicate compuesto
        // $ TODO: Crea dos Predicates y combínalos con .and()
        // $ - Uno que valide si un número es mayor a 10
        // $ - Otro que valide si es menor a 20
        // $ - Combínalos para validar si está entre 10 y 20
        Predicate<Integer> mayorQue10 = a -> a > 10;
        Predicate<Integer> menorQue20 = a -> a < 20;
        Predicate<Integer> entre10y20 = mayorQue10.and(menorQue20); // mayorQue10.and(menorQue20)

        System.out.println("- Ejercicio 9: " + entre10y20.test(15)); // true
        System.out.println("- Ejercicio 9: " + entre10y20.test(25)); // false


        // $ EJERCICIO 1.10: Function encadenada
        // $ TODO: Crea dos Functions y encadénalas con .andThen()
        // $ - Una que multiplique un número por 2
        // $ - Otra que le sume 10 al resultado
        Function<Integer, Integer> multiplicarPor2 = a -> a * 2;
        Function<Integer, Integer> sumar10 = a -> a + 10;
        Function<Integer, Integer> multiplicarYSumar = multiplicarPor2.andThen(sumar10); // multiplicarPor2.andThen(sumar10)

        System.out.println("- Ejercicio 10: " + multiplicarYSumar.apply(5)); // (5*2)+10 = 20
    }
}
