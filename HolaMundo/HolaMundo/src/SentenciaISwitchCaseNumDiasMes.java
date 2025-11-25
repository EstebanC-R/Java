import java.util.Scanner;

public class SentenciaISwitchCaseNumDiasMes {
    static void main(String[] args) {

        Scanner rl = new Scanner(System.in);
        System.out.println("Ingrese el número del mes 1 - 12: ");
        int mes = rl.nextInt();
        int numeroDias = 0;

        System.out.println("Ingrese el número del año (YYYY): ");
        int anio = rl.nextInt();

        switch (mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 2:
                if(anio % 400 == 0 || ( anio % 4 == 0 && !(anio % 100 == 0))){
                    numeroDias = 29;
                }else{
                    numeroDias = 28;
                }
                break;
            default:
                System.out.println("Seleccione un mes del rango 1 - 12.");
                break;
        }
        System.out.println("Numero de días = " + numeroDias);
    }
}
