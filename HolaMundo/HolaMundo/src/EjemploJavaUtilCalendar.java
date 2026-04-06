import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EjemploJavaUtilCalendar {
    static void main() {

        Calendar calendario = Calendar.getInstance();
        // $ De esta forma se puede poner una fecha anterior o pasada.

        // ? Forma resumida.
        // ! calendario.set(2020, Calendar.SEPTEMBER, 25, 18, 20, 10);

        // ? Forma larga de lo anterior, pero más intuitiva.
        calendario.set(Calendar.YEAR, 2025);
        calendario.set(Calendar.MONTH, Calendar.DECEMBER);
        calendario.set(Calendar.DAY_OF_MONTH, 25);

        /* ! calendario.set(Calendar.HOUR_OF_DAY, 21); */ // * Hay que tener en cuenta que este es para formato 24 horas
        calendario.set(Calendar.HOUR, 9);
        calendario.set(Calendar.AM_PM, Calendar.PM);
        calendario.set(Calendar.MINUTE, 20);
        calendario.set(Calendar.SECOND, 10);
        calendario.set(Calendar.MILLISECOND, 125);


        Date fecha = calendario.getTime();
        System.out.println("Fecha sin formato = " + fecha);

        SimpleDateFormat formato = new SimpleDateFormat("yyyy - MMMM - EEEE dd - hh:mm:ss:SSS a"); // * la 'a' al final es para am o pm,
        // * También el poner HH y hh es distinto uno es para formato 24 horas(HH) y formato 12 horas(hh)
        String fechaConFormato = formato.format(fecha);
        System.out.println("Fecha con formato = " + fechaConFormato);


        // $ Ahora vamos a ver con Calendar pero para traer la fecha actual.

        Calendar calendarioActual = Calendar.getInstance();
        Date fecha2 = calendarioActual.getTime();


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

    }
}
