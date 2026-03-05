package com.esteban.gestionar_autores.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate parse(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    public static String format(LocalDate date) {
        return date.format(FORMATTER);
    }

}
