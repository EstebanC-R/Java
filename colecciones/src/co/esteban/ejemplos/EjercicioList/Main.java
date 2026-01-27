package co.esteban.ejemplos.EjercicioList;

import java.sql.SQLOutput;
import java.util.*;

import static co.esteban.ejemplos.EjercicioList.Origen.*;
import static co.esteban.ejemplos.EjercicioList.Destino.SANTIAGO;
public class Main {
    public static void main(String[] args) {

        List<Vuelo> vuelos = new ArrayList<>();

        vuelos.add(new Vuelo("AAL 933", NEW_YORK, SANTIAGO, Vuelo.fixFechaHora("Lun 29 Ago 2021 05:39 hrs"), 62));
        vuelos.add(new Vuelo("LAT 755", SAO_PAULO, SANTIAGO, Vuelo.fixFechaHora("Lun 31 Ago 2021 04:45 hrs"), 47));
        vuelos.add(new Vuelo("SKU 621", RIO_DE_JANEIRO, SANTIAGO, Vuelo.fixFechaHora("Lun 30 Ago 2021 16:00 hrs"), 52));
        vuelos.add(new Vuelo("DAL 147", ATLANTA, SANTIAGO, Vuelo.fixFechaHora("Lun 29 Ago 2021 13:22 hrs"), 59));
        vuelos.add(new Vuelo("AVA 241", BOGOTA, SANTIAGO, Vuelo.fixFechaHora("Lun 31 Ago 2021 14:05 hrs"), 25));
        vuelos.add(new Vuelo("AMX 10", MEXICO_CITY, SANTIAGO, Vuelo.fixFechaHora("Lun 31 Ago 2021 05:20 hrs"), 29));
        vuelos.add(new Vuelo("IBE 6833", LONDRES, SANTIAGO, Vuelo.fixFechaHora("Lun 30 Ago 2021 08:45 hrs"), 55));
        vuelos.add(new Vuelo("LAT 2479", FRANKFURT, SANTIAGO, Vuelo.fixFechaHora("Lun 29 Ago 2021 07:41 hrs"), 51));
        vuelos.add(new Vuelo("SKU 803", LIMA, SANTIAGO, Vuelo.fixFechaHora("Lun 30 Ago 2021 10:35 hrs"), 48));
        vuelos.add(new Vuelo("LAT 533", LOS_ANGELES, SANTIAGO, Vuelo.fixFechaHora("Lun 29 Ago 2021 09:14 hrs"), 59));
        vuelos.add(new Vuelo("LAT 1447", GUAYAQUIL, SANTIAGO, Vuelo.fixFechaHora("Lun 31 Ago 2021 08:33 hrs"), 31));
        vuelos.add(new Vuelo("CMP 111", PANAMA_CITY, SANTIAGO, Vuelo.fixFechaHora("Lun 31 Ago 2021 15:15 hrs"), 29));
        vuelos.add(new Vuelo("LAT 705", MADRID, SANTIAGO, Vuelo.fixFechaHora("Lun 30 Ago 2021 08:14 hrs"), 47));
        vuelos.add(new Vuelo("AAL 957", MIAMI, SANTIAGO, Vuelo.fixFechaHora("Lun 29 Ago 2021 22:53 hrs"), 60));
        vuelos.add(new Vuelo("ARG 5091", BUENOS_AIRES, SANTIAGO, Vuelo.fixFechaHora("Lun 31 Ago 2021 09:57 hrs"), 32));
        vuelos.add(new Vuelo("LAT 1283", CANCUN, SANTIAGO, Vuelo.fixFechaHora("Lun 31 Ago 2021 04:00 hrs"), 35));
        vuelos.add(new Vuelo("LAT 579", BARCELONA, SANTIAGO, Vuelo.fixFechaHora("Lun 29 Ago 2021 07:45 hrs"), 61));
        vuelos.add(new Vuelo("AAL 945", DALLAS_FORT_WORTH, SANTIAGO, Vuelo.fixFechaHora("Lun 30 Ago 2021 07:12 hrs"), 58));
        vuelos.add(new Vuelo("LAT 501", PARIS, SANTIAGO, Vuelo.fixFechaHora("Lun 29 Ago 2021 18:29 hrs"), 49));
        vuelos.add(new Vuelo("LAT 405", MONTEVIDEO, SANTIAGO, Vuelo.fixFechaHora("Lun 30 Ago 2021 15:45 hrs"), 39));

        System.out.printf("%-6s %-18s | %-18s | %-18s | %-28s | %s %s", "|", "VUELO", "ORIGEN", "DESTINO", "FECHA Y HORA DE LLEGADA", " NUM PASAJEROS  ", "|\n");
        vuelos.forEach(System.out::println);

        System.out.println();

        Collections.sort(vuelos, (a, b) -> b.getFechaLlegadaYHora().compareTo(a.getFechaLlegadaYHora()));

        System.out.println("\n==================================== Orden de llegada de forma Ascendente ==========================================\n");
        System.out.printf("%-6s %-18s | %-18s | %-18s | %-28s | %s %s", "|", "VUELO", "ORIGEN", "DESTINO", "FECHA Y HORA DE LLEGADA", " NUM PASAJEROS  ", "|\n");
        vuelos.forEach(System.out::println);


        Vuelo ultimo = vuelos.getFirst();

        System.out.println("\n==========================================================================================================================================================");
        System.out.println("\tEl ultimo vuelo por fecha de llegada es: " + ultimo.getNombre() + " origen " + ultimo.getOrigen() +
                " destino " + ultimo.getDestino() + " la fecha y hora de llegada es el " + ultimo.getFechaLlegadaYHora());
        System.out.println("==========================================================================================================================================================");

        vuelos.sort(Comparator.comparing((Vuelo::getCantidadPasajeros)));

        Vuelo vueloConMenorPasajeros = vuelos.getFirst();

        System.out.println("\n===============================================================================================================================================================================");
        System.out.println("\tEl vuelo con menos pasajeros es: " + vueloConMenorPasajeros.getNombre() + " origen " + vueloConMenorPasajeros.getOrigen() +
                " destino " + vueloConMenorPasajeros.getDestino() + " la fecha y hora de llegada es el " + vueloConMenorPasajeros.getFechaLlegadaYHora() +
                " el número de pasajeros es de: " + vueloConMenorPasajeros.getCantidadPasajeros());
        System.out.println("===============================================================================================================================================================================");

    }
}
