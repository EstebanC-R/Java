package mes_2.Java_semana_6.temas22_java_moderno_record_y_switch_mejorado.switchMejorado;

import java.util.Scanner;

public class SwitchMejoradoEjemplo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese una fruta (manzana, banana, naranja):");
        String fruta = scanner.nextLine().toLowerCase(); // Leer y convertir a minúsculas

        // --- Uso del switch mejorado como expresión ---

        String colorAsignado = switch (fruta) {
            case "manzana" -> "Rojo o Verde";
            case "banana" -> "Amarillo";
            case "naranja" -> "Naranja";
            // El default es obligatorio si el switch se usa como expresión y los casos no son exhaustivos (como en un enum)
            default -> "Color desconocido";
        };

        // --- Resultado ---

        System.out.println("\n--- Resultado ---");
        System.out.println("Fruta ingresada: " + fruta);
        System.out.println("Color: " + colorAsignado);

        scanner.close();
    }
}