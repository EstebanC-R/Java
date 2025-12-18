import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EjemploJavaUtilDateParse {
    static void main(String[] args) {

        Scanner rl = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Ingrese una fecha con formato 'yyyy-MM-dd' : ");
        try {
            Date fecha = df.parse(rl.nextLine());
            System.out.println("fecha = " + fecha);
            System.out.println("df.format(fecha) = " + df.format(fecha));

            Date fecha2 = new Date();
            System.out.println("fecha2 = " + fecha2);

            // $ Para validar si la fecha ingresada es anterior o posterior a la fecha actual.

            if(fecha.after(fecha2)){
                System.out.println("fecha (del usuario) es después que fecha 2 (actual)");
            }else if(fecha.before(fecha2)){
                System.out.println("fecha es anterior que fecha2");
            }else if(fecha.equals(fecha2)){
                System.out.println("fecha es igual a fecha2");
            }

            // $ Está es anterior a la version anterior que es con after, before o equals, pero un poco más enredada.
            if(fecha.compareTo(fecha2) > 0){
                System.out.println("fecha (del usuario) es después que fecha 2 (actual)");
            }else if(fecha.compareTo(fecha2) < 0){
                System.out.println("fecha es anterior que fecha2");
            }else if(fecha.compareTo(fecha2) == 0){
                System.out.println("fecha es igual a fecha2");
            }


        } catch (ParseException e) {
            System.err.println("Mensaje = " + e.getMessage());
            System.err.println("The format is: " + "yyyy - MM - dd");
            main(args);
        }

    }
}
