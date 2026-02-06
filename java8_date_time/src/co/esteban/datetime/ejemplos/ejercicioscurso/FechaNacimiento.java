package co.esteban.datetime.ejemplos.ejercicioscurso;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FechaNacimiento {
    public static void main(String[] args) {

        LocalDate fechaActual = LocalDate.now();
        Scanner rl = new Scanner(System.in);

        System.out.print("\nIngresa tú fecha de nacimiento (Día-Mes-Año) con valores numéricos: ");
        String respuesta = rl.nextLine();

        LocalDate fechaNacimiento = LocalDate.now();

        try {
            fechaNacimiento = LocalDate.parse(respuesta, (DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        } catch (IllegalArgumentException | DateTimeParseException e){
            System.out.println("Mensaje: "+ e.getMessage());
            System.out.println("\nIngresa la fecha tal cual se te indica, recuerda también que si es\nun solo digito es con cero adelante ejemplo: 03-01-2000");
            main(args);
        }

        Period edad = Period.between(fechaNacimiento, fechaActual);

        if(edad.getYears() != 0){
            System.out.println("\nTú edad actual es de: " + edad.getYears() + " años.");
        }
    }
}
