package co.esteban.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjemploZonedDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaLocal = LocalDateTime.parse("2026/09/23 12:45"
                , DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));

        //ZoneId newYork = ZoneId.of("America/New_York");
        //ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00"));

        ZonedDateTime zonaNy = fechaLocal.atZone(ZoneOffset.of("-04:00"));

        System.out.println("Horario de partida en New York: " + zonaNy);

        // ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNy.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(8);
        System.out.println("Hora de llegada en Madrid: " + zonaMadrid);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd - MMM - yyyy | hh:mm:ss a");
        System.out.println("Detalles del viaje a España: " );
        System.out.println("Partida de NY: " + df.format(zonaNy));
        System.out.println("Llegada Madrid: " + df.format(zonaMadrid));

        /*Set<String> zonas = ZoneId.getAvailableZoneIds();
        zonas.forEach(System.out::println);*/

        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
