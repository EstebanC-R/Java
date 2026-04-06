import java.util.Scanner;

public class SentenciaSwitchCase {
    static void main(String[] args) {
        Scanner rl = new Scanner(System.in);

        System.out.println("Ingresa el numero del mes para conocerlo (1-12): ");
        int numeroMes = rl.nextInt();

        switch (numeroMes){
            case 1:
                System.out.println("El mes es Enero!");
                break;
            case 2:
                System.out.println("El mes es Febrero!");
                break;
            case 3:
                System.out.println("El mes es Marzo!");
                break;
            case 4:
                System.out.println("El mes es Abril!");
                break;
            case 5:
                System.out.println("El mes es Mayo!");
                break;
            case 6:
                System.out.println("El mes es Junio!");
                break;
            case 7:
                System.out.println("El mes es Julio!");
                break;
            case 8:
                System.out.println("El mes es Agosto!");
                break;
            case 9:
                System.out.println("El mes es Septiembre!");
                break;
            case 10:
                System.out.println("El mes es Octubre!");
                break;
            case 11:
                System.out.println("El mes es Noviembre!");
                break;
            case 12:
                System.out.println("El mes es Diciembre!");
                break;
            default:
                System.out.println("Ingrese un mes del 1 al 12!");
                break;
        }

        int num = 1;

        switch (num){
            case 0:
                System.out.println("El número es cero.");
                break;
            case 1:
                System.out.println("El número es uno.");
                break;
            case 2:
                System.out.println("El número es dos.");
                break;
            case 3:
                System.out.println("El número es tres.");
                break;
            default:
                System.out.println("Por favor pon el número bien.");
        }

        String nombre = "pepe";

        switch (nombre){
            case "admin":
                System.out.println("Hola admin, bienvenido!");
                break;
            case "Milton":
                System.out.println("Hola " + nombre + "!");
                break;
            case "pepe":
                System.out.println("Hola pepe!");
                break;
            default:
                System.out.println("Usuario desconocido!");
                break;
        }
    }
}
