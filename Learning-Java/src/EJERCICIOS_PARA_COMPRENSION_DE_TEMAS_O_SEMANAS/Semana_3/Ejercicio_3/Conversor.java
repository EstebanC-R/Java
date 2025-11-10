package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_3;

import java.util.Scanner;

public class Conversor {

    //---------------------- Celsius a Fahrenheit ------------------------------

    static double ingresarCelsius(Scanner rl){
        System.out.println("Ingrese el valor de Celsius para pasar a Fahrenheit: ");
        while(!rl.hasNextDouble()){
            System.out.println("Ingrese un valor valido (Texto no, Recuerde que es con ',' y no '.', en caso de que su valor tenga décimas): ");
            rl.next();
        }

        double respuesta = rl.nextDouble();
        return respuesta;
    }

    static double celsiusAFahrenheit(double celsius){
        return (celsius * 1.8) + 32;
    }
    //---------------------- Fahrenheit a Celsius ------------------------------

    static double ingresarFahrenheit(Scanner rl){
        System.out.println("Ingrese el valor de Celsius para pasar a Fahrenheit: ");

        while(!rl.hasNextDouble()){
            System.out.println("Ingrese un valor valido (Texto no, Recuerde que es con ',' y no '.', en caso de que su valor tenga décimas): ");
            rl.next();
        }

        double respuesta = rl.nextDouble();
        return respuesta;
    }

    static double fahrenheitACelsius(double fahrenheit){
        return (fahrenheit - 32) / 1.8;
    }

    //---------------------- Metros a Pies ------------------------------

    static double ingresarMetros(Scanner rl){
        System.out.println("Ingrese los Métros que quiera convertir a Pies: ");
        while(!rl.hasNextDouble()){
            System.out.println("Por favor ingrese un valor valido ( Texto no y recuerde que es ',' y no '.' en caso de que su valor tenga décimas)");
            rl.next();
        }

        double respuesta = rl.nextDouble();
        return respuesta;
    }

    static double metrosAPies(double metros){
        return metros * 3.28084;
    }

    //---------------------- Pies a Metros ------------------------------

    static double ingresaPies(Scanner rl){
        System.out.println("Ingrese los Pies que quiera convertir a Métros: ");
        while(!rl.hasNextDouble()){
            System.out.println("Por favor ingrese un valor valido ( Texto no y recuerde que es ',' y no '.' en caso de que su valor tenga décimas)");
            rl.next();
        }

        double respuesta = rl.nextDouble();
        return respuesta;
    }

    static double piesAMetros(double pies){
        return pies * 0.3048;
    }
}
