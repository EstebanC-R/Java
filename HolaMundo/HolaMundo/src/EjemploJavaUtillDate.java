import java.text.SimpleDateFormat;
import java.util.Date;

public class EjemploJavaUtillDate {
    static void main() {
        Date fecha = new Date();

        System.out.println("fecha = " + fecha);

        SimpleDateFormat df = new SimpleDateFormat("EEEE dd 'de' MMMM 'del' yyyy"); // ? Si colocamos 2 MM muestra el número del mes,
        // ? pero si es 4 MMMMM muestra el nombre del mes, por último con 3 MMM muestra el mes recortado.
        String fechaStr = df.format(fecha);

        long j = 0;
        for(int i = 0; i < 10000000; i++){
            j += i;
        }
        System.out.println("j = " + j);
        Date fecha2 = new Date();
        long timpoFinal = fecha2.getTime() - fecha.getTime();
        System.out.println("Tiempo transcurrido en el for = " + timpoFinal);


        System.out.println("fechaStr = " + fechaStr);


    }
}
