import java.util.Scanner;

public class OperadorTernario {
    static void main(String[] args) {
        String variable = 8 == 8 ? "Si, es verdadero." : "No, no es verdadero.";
        System.out.println("variable = " + variable);

        String estado = "";
        double promedio = 0.0;

        double matematicas = 0.0;
        double ciencias = 0.0;
        double historia = 0.0;

        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese la nota de matematicas entre 1.0 y 5.0: ");
        matematicas = rl.nextDouble();

        System.out.println("Ingrese la nota de ciencias entre 1.0 y 5.0: ");
        ciencias = rl.nextDouble();

        System.out.println("Ingrese la nota de historia entre 1.0 y 5.0: ");
        historia = rl.nextDouble();

        promedio = (matematicas + ciencias + historia) / 3;

        estado = promedio >= 3.5 ? "Aprobaste." : "No aprobaste, sigue intentando.";
        System.out.println("Estado = " + estado);
        System.out.printf("Tu promedio fue: %.2f", promedio);

        /*if(promedio >= 5.49){
            estado = "Aprobaste.";
        }else{
            estado = "No aprobaste, sigue intentando.";
        }*/
    }
}
