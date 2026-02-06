package co.esteban.datetime.ejemplos;

import org.w3c.dom.Text;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {
        // ! Cosas a tomar en cuenta es que el new Locale("es", "ES")
        // ! ya esta obsoleto(@Deprecated) desde la version 19 por lo que podía causar errores,
        // ! se siguió utilizando = locale.forLenguageTag("es-ES")


        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Día = " + fechaActual.getDayOfMonth());
        Month mes = fechaActual.getMonth();
        System.out.println("Mes = " + mes);
        System.out.println("Número del mes = " + mes.getValue());
        System.out.println("Mes español = " + mes.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-CO")));

        DayOfWeek dia = fechaActual.getDayOfWeek();
        System.out.println("Número del día = " + dia.getValue());
        System.out.println("Día en español = " + dia.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-CO")));
        System.out.println("Año = " + fechaActual.getYear());
        System.out.println("Día del año = " + fechaActual.getDayOfYear());
        System.out.println("Era = " + fechaActual.getEra());

        fechaActual = LocalDate.of(2026, 2, 4);
        System.out.println("fechaActual = " + fechaActual);
        
        fechaActual = LocalDate.of(2026, Month.FEBRUARY, 4);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2026-02-04");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate diaDeManiana = LocalDate.now().plusDays(1);
        System.out.println("diaDeManiana = " + diaDeManiana);
        
        LocalDate mesAnteriorMismoDia = LocalDate.now().minusMonths(1);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        LocalDate mesAnteriorMismoDia2 = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("mesAnteriorMismoDia2 = " + mesAnteriorMismoDia2);

        DayOfWeek lunes = LocalDate.parse("2026-02-02").getDayOfWeek();
        System.out.println("Lunes = " + lunes);

        int cuatro = LocalDate.of(2026, 2, 04).getDayOfMonth();
        System.out.println("cuatro = " + cuatro);
        
        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        // $ esto es como decir | ESTE es ANTES que ESTE |
        boolean esAntes = LocalDate.of(2026,2,4).isBefore(LocalDate.parse("2026-02-03"));
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = LocalDate.of(2026, 2, 4).isAfter(LocalDate.parse("2026-02-02"));
        System.out.println("esDespues = " + esDespues);

        esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);
    }
}
