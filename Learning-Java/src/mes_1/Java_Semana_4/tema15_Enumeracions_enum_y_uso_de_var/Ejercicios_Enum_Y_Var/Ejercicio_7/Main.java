package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_7;

import java.util.Scanner;

public class Main {

    public static double pedirDato(Scanner rl, String texto) {
        System.out.println(texto);
        while (!rl.hasNextDouble()) {
            System.out.println("Por favor ingrese un número válido: ");
            rl.next();
        }
        return rl.nextDouble();
    }

    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);

        System.out.println("Por favor selecciona la operación que quieres hacer: ");
        int i = 1;
        for (Operacion op : Operacion.values()) {
            System.out.printf("%d - %-15s (%s)%n", i, op.getMetodo(), op.getSign());
            i++;
        }

        int seleccion;
        do {
            System.out.print("Selección (1-4): ");
            while (!rl.hasNextInt()) {
                System.out.println("Debe ingresar un número entre 1 y 4.");
                rl.next();
            }
            seleccion = rl.nextInt();
        } while (seleccion < 1 || seleccion > 4);


        Operacion operacionElegida = Operacion.values()[seleccion - 1];

        System.out.printf("%nHas elegido: %s%n", operacionElegida.getMetodo());

        double a = pedirDato(rl, "Ingrese el primer número: "); // ---> esto es el texto que le entra a pedirDatos
        double b = pedirDato(rl, "Ingrese el segundo número: ");

        double resultado = operacionElegida.calcular(a, b);

        System.out.printf("%n Resultado de la %s: %.2f %s %.2f = %.1f%n",
                operacionElegida.getMetodo(), a, operacionElegida.getSign(), b, resultado);

        rl.close();
    }
}
