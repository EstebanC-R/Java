import java.util.Scanner;

public class OperadorTernarioNumeroMayor {
    static void main(String[] args) {
        int max = 0;

        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese un número: ");
        int num1 = rl.nextInt();

        System.out.println("Ingrese el segundo número: ");
        int num2 = rl.nextInt();

        System.out.println("Ingrese el tercer número: ");
        int num3 = rl.nextInt();

        System.out.println("Ingrese el cuarto número: ");
        int num4 = rl.nextInt();

        max = num1 > num2 ? num1 : num2;
        max = max > num3 ? max : num3;
        max = max > num4 ? max : num4;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);
        System.out.println("El número maximo es: " + max);
    }
}
