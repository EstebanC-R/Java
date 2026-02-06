package co.esteban.datetime.ejemplos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EjemploLocalTime {
    public static void main(String[] args) {

        LocalTime ahora = LocalTime.now();
        System.out.println("ahora = " + ahora);
        System.out.println("Hora = " + ahora.getHour());
        System.out.println("Minutos = " + ahora.getMinute());
        System.out.println("Segundos = " + ahora.getSecond());


        LocalTime seisConTreinta = LocalTime.of(6, 30, 26);
        System.out.println("seisConTreinta = " + seisConTreinta);

        seisConTreinta = LocalTime.parse("18:30");
        System.out.println("seisConTreinta = " + seisConTreinta);
        LocalTime sieteConTreinta = seisConTreinta.plusHours(1);
        System.out.println("sieteConTreinta = " + sieteConTreinta);

        boolean esAnterior = LocalTime.of(4, 50).isBefore(LocalTime.parse("07:30"));
        System.out.println("esAnterior = " + esAnterior);

        // $ La única que puede ir en mayuscula o minuscula es la hora
        // $ Mayuscula HH = Formato 24 horas.
        // $ Minuscula hh = Formato am/pm.
        // $ La "a" al final es para designar segun corresponda am o pm
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String ahoraFormateado = seisConTreinta.format(df);
        System.out.println(ahoraFormateado);
        
        ahoraFormateado = df.format(ahora);
        System.out.println("ahoraFormateado = " + ahoraFormateado);
        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;

        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
