package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_3;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    public static void menu(){
        Scanner rl = new Scanner(System.in);

        System.out.println("\n---------- Por favor selecciona un número dependiendo la opción que deseas ejecutar: ----------\n");
        System.out.println("1. Encontrar un número maximo de una lista de números.");
        System.out.println("2. Encontrar un número mínimo de una lista de números.");
        System.out.println("3. Calcular el promedio de una lista de números.");
        System.out.println("4. El número es primo?.");
        System.out.println("5. Invertir texto.");
        System.out.println("6. Celsius a Fahrenheit.");
        System.out.println("7. Fahrenheit a Celsius.");
        System.out.println("8. Metros a Pies.");
        System.out.println("9. Pies a Metros.");
        System.out.println("---------- 10. Salir. ----------");
        System.out.println("Respuesta: ");


        int opcion;

        if(rl.hasNextInt()){
            opcion = rl.nextInt();

            if(opcion > 10){
                System.out.println("Pon un número dentro del rango antes dicho. :P");
            }else{
                switch (opcion){
                    case 1:
                        int[] datosNum = Utilidades.encontrarMaximo(rl);
                        int max = Utilidades.calcularMaximo(datosNum);
                        System.out.println("El número mayor es: " + max);
                        Pregunta.pregunta(rl);
                        break;
                    case 2:
                        int[] datosMinimos = Utilidades.encontrarMinimo(rl);
                        int min = Utilidades.calcularMinimo(datosMinimos);
                        System.out.println("- Lista: " + Arrays.toString(datosMinimos));
                        System.out.println("- El número menor es: " + min);
                        Pregunta.pregunta(rl);
                        break;
                    case 3:
                        int[] datosProm = Utilidades.encontrarPromedio(rl);
                        double prom = Utilidades.calcularPromedio(datosProm);
                        System.out.println("- Lista : " + Arrays.toString(datosProm));
                        System.out.printf("- Promedio: %.2f\n", prom);
                        Pregunta.pregunta(rl);
                        break;
                    case 4:
                        int datoNum = Utilidades.ingresarPrimo(rl);
                        boolean valor = Utilidades.esPrimo(datoNum);
                        System.out.println("- "+ datoNum +" = " + valor);
                        Pregunta.pregunta(rl);
                        break;
                    case 5:
                        String datoString = Utilidades.ingresarCadena(rl);
                        String invertir = Utilidades.invertirCadena(datoString);
                        System.out.println("Texto invertido: " +  invertir);
                        Pregunta.pregunta(rl);
                        break;
                    case 6:
                        double datoCelsius = Conversor.ingresarCelsius(rl);
                        double respuesta = Conversor.celsiusAFahrenheit(datoCelsius);
                        System.out.printf("- Celsius    = %.2f\n", datoCelsius);
                        System.out.printf("- Fahrenheit = %.2f\n", respuesta);
                        Pregunta.pregunta(rl);
                        break;
                    case 7:
                        double dateFahrenheit = Conversor.ingresarFahrenheit(rl);
                        double dateCelsius = Conversor.fahrenheitACelsius(dateFahrenheit);
                        System.out.printf("- Fahrenheit    = %.2f\n", dateFahrenheit);
                        System.out.printf("- Celsius = %.2f\n", dateCelsius);
                        Pregunta.pregunta(rl);
                        break;
                    case 8:
                        double datoMetros = Conversor.ingresarMetros(rl);
                        double respuestaEnPies = Conversor.metrosAPies(datoMetros);
                        System.out.printf("- Métros = %.2f métros\n", datoMetros);
                        System.out.printf("- Pies   = %.2f ft\n", respuestaEnPies);
                        Pregunta.pregunta(rl);
                        break;
                    case 9:
                        double datoPies = Conversor.ingresaPies(rl);
                        double respuestaEnMetros = Conversor.piesAMetros(datoPies);
                        System.out.printf("- Pies    = %.2f ft\n", datoPies);
                        System.out.printf("- Métros  = %.2f métros\n", respuestaEnMetros);
                        Pregunta.pregunta(rl);
                        break;
                    case 10:
                        System.out.println("Gracias por utilizar nuestro sistema, toma, aquí tienes un pastel 🎂 😁");
                        rl.close();
                        break;
                    default:
                        System.out.println("Por favor ingrese un valor valido, dentro del rango de las opciones 😠: ");
                        rl.next();
                        menu();
                        break;
                }
            }
        }else{
            System.out.println("Por favor selecciona un número valido");
        }
    }
}
