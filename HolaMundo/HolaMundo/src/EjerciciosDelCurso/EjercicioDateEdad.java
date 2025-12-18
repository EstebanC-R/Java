package EjerciciosDelCurso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class EjercicioDateEdad {
    static void main() {

        Scanner rl = new Scanner(System.in);
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendario = Calendar.getInstance();
        Date fechaActual = calendario.getTime();

        System.out.println("Ingresa tú fecha de nacimiento con el formato 'dd-MM-yyyy' = ");

        try {
            Date fechaEdad = sf.parse(rl.nextLine());
            int edad = fechaActual.getYear() - fechaEdad.getYear();
            System.out.println("Edad actual = " + edad);
        }catch (ParseException e){
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}
