package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_4;

import java.util.Scanner;

public class Menu {

    public static void menu(){
        Scanner rl = new Scanner(System.in);

        System.out.println("\nSi quieres saber el perimetro y área de determinada figura escoge la opción según quieras: ");
        System.out.println("1. Circulo");
        System.out.println("2. Rectángulo");
        System.out.println("3. Triangulo");
        System.out.println("\nRespuesta: ");

        int opcion = rl.nextInt();

        while(opcion < 1 || opcion > 4 ){
            System.out.println("Escoge un valor dentro del rango de opciones (1 a 3): ");
            while(!rl.hasNextInt()){
                System.out.println("Dato invalido, intenta de nuevo: ");
                rl.next();
            }
            opcion = rl.nextInt();
        }

        switch (opcion){
            case 1:
                System.out.println("Ingresa el Radio del Circulo: ");
                double radio = comprobarDouble(rl);
                rl.nextLine();

                String colorCirculo = nombreColor(rl);

                Circulo cir = new Circulo(colorCirculo, radio);
                cir.mostrarInformacion();
                break;
            case 2:
                System.out.println("Ingrese la altura del Rectángulo: ");
                double altura = comprobarDouble(rl);

                System.out.println("Ahora ingrese el valor de la base del Rectángulo: ");
                double base = comprobarDouble(rl);

                String colorRectangulo = nombreColor(rl);

                Rectangulo rec = new Rectangulo(colorRectangulo, altura, base);
                rec.mostrarInformacion();
                break;
            case 3:
                System.out.println("Ingrese la altura del Triangulo: ");
                altura = comprobarDouble(rl);

                System.out.println("Ahora ingrese el valor de la base del Triángulo: ");
                base = comprobarDouble(rl);

                String colorTriangulo = nombreColor(rl);

                Triangulo tri = new Triangulo(colorTriangulo, altura, base);
                tri.mostrarInformacion();
                break;
            case 4:
                System.out.println("Gracias por utilizar nuestro sistema, hasta la próxima :) :P (^_^)");
                rl.close();
                break;
            default:
                System.out.println("Por favor seleccione una opción valida: ");
                menu();
                break;
        }
    }


    public static double comprobarDouble(Scanner rl){
        while (!rl.hasNextDouble()){
            System.out.println("Por favor ingrese el valor en números a poder ser, si tiene decimales utilice ',': ");
            rl.next();
        }
        return rl.nextDouble();
    }

    public static String nombreColor(Scanner rl){
        System.out.println("Ingresa el color deseado: ");

        while (rl.hasNextDouble()){
            System.out.println("Ingrese un color con letras, no en formato bit: ");
            rl.next();
        }

        String color = rl.next();

        return color;
    }
}
