package EJERCICIOS_MES_1.Semana01_Calculadora;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args){

        // CALCULADORA
        Scanner rl = new Scanner(System.in);
        String despedida = "Hasta luego, Gracias por utilizar nuestro sistema :) :P (^_^)";
        String mensaje = """
            Hola que tal? Bienvenido al sistema de calculadoraXRT@2,
            Por favor elija la opción que desee calcular:
            1- Suma.
            2- Resta.
            3- Multiplicación.
            4- Division.
            5- Es par?.
            6- salir.
        Respuesta:__
        """;

        System.out.println("\n" + mensaje);

        int a = 0, b = 0, c;

        if(rl.hasNextInt()){
            int seleccion = rl.nextInt();
            switch (seleccion){
                case 1:
                    System.out.println("Ponga su primer número: ");
                    a = rl.nextInt();

                    System.out.println("Ponga su segundo número: ");
                    b = rl.nextInt();

                    System.out.println("\n" + "Resultado = " + sumar(a, b));

                    deNuevo(rl);
                    break;
                case 2:
                    System.out.println("Ponga su primer número: ");
                    a = rl.nextInt();

                    System.out.println("Ponga su segundo número: ");
                    b = rl.nextInt();

                    System.out.println("\n" + "Resultado = " + resta(a, b));

                    deNuevo(rl);
                    break;
                case 3:
                    System.out.println("Ponga su primer número: ");
                    a = rl.nextInt();

                    System.out.println("Ponga su segundo número: ");
                    b = rl.nextInt();

                    System.out.println("\n" + "Resultado = " + multiplicar(a, b));

                    deNuevo(rl);
                    break;
                case 4:
                    System.out.println("Ponga su primer número: ");
                    a = rl.nextInt();

                    System.out.println("Ponga su segundo número: ");
                    b = rl.nextInt();

                    System.out.println("\n" + "Resultado = " + division(a, b));

                    deNuevo(rl);
                    break;
                case 5:
                    System.out.println("Cual número quiere saber si es o no par: ");
                    c = rl.nextInt();

                    System.out.println("\n" + esPar(c));

                    deNuevo(rl);
                    break;
                case 6:
                    System.out.println(despedida);
                    rl.close();
                    break;
                default:
                    System.out.println("Creo que se confundio de opción, vuelva a intentarlo :)");
                    main(null);
            }
        }else{
            System.out.println("Tienes que seleccionar un número como se indica en las opciones.");
            main(null);
        }
    }

    public static int sumar(int a, int b){
        return a + b;
    }

    public static int resta(int a, int b){
        return a - b;
    }

    public static int multiplicar(int a, int b){
        return a * b;
    }

    public static int division(int a, int b){
        if(b == 0){
            System.out.println("No puedes dividir por cero, vuelve a intentarlo con otro valor.");
            main(null);
            return 0;
        }else{
            return a / b;
        }
    }

    public static int esPar(int num){
        if(num % 2 == 0){
            System.out.println("\nEl número: " + num + " es par.");
            return 1;
        }else{
            System.out.println("El número: " + num + " es impar.");
            return 0;
        }
    }

    public static String deNuevo(Scanner rl){

        String despedida = "Hasta luego, Gracias por utilizar nuestro sistema :) :P (^_^)";

        System.out.println("\nQuieres hacer otra operación? 1) si. 2) no");
        rl.nextLine();
        String respuesta = rl.nextLine();

        if(respuesta.equals("si") || respuesta.equals("1")){
            main(null);
            return "";
        }else if(respuesta.equals("no") || respuesta.equals("2")){
            System.out.println(despedida);
            rl.close();
            return "";
        }else{
            System.out.println("Creo que escribiste mal tu respuesta, vulve a responder: ");
            return deNuevo(rl);
        }
    }
}