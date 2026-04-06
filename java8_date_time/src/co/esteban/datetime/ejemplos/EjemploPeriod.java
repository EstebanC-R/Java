package co.esteban.datetime.ejemplos;

import java.time.LocalDate;
import java.time.Period;

public class EjemploPeriod {
    public static void main(String[] args) {

        LocalDate fecha1 = LocalDate.of(2004, 2, 4);
        LocalDate fecha2 = LocalDate.of(2026, 2, 4);

        // # Devuelven nueva instancia sin modificar la original.

        LocalDate fecha3 = fecha2.withMonth(12);


        fecha3 = fecha3.withDayOfMonth(28);


        Period periodo = Period.between(fecha1, fecha3);
        System.out.println("periodo = " + periodo);

        System.out.printf("Periodo entre %s y %s es: %d años %d meses y %d días", fecha1, fecha3, periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}
