import java.util.Scanner;

public class ExcersiceTEst {
    public static void main (String[] args) {
        Scanner rl = new Scanner(System.in);

        System.out.println("Primer nombre: ");
        String nombre1 = rl.nextLine();
        String segundoElemento1 = nombre1.substring(1, 2).toUpperCase();
        String ultimosElementos1 = nombre1.substring(nombre1.length() - 2);

        System.out.println("Segundo nombre: ");
        String nombre2 = rl.nextLine();
        String segundoElemento2 = nombre2.substring(1, 2).toUpperCase();
        String ultimosElementos2 = nombre2.substring(nombre2.length() - 2);

        System.out.println("Tercer nombre: ");
        String nombre3 = rl.nextLine();
        String segundoElemento3 = nombre3.substring(1, 2).toUpperCase();
        String ultimosElementos3 = nombre3.substring(nombre3.length() - 2);

        StringBuilder sb = new StringBuilder();

        System.out.print(sb.append(segundoElemento1).append(".").append(ultimosElementos1).append("_").append(segundoElemento2).append(".").append(ultimosElementos2).append("_").append(segundoElemento3).append(".").append(ultimosElementos3));
    }
}
