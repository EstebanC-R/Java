package EJERCICIOS_MES_2.Semana06_cajero_automatico_con_validaciones_y_control_de_errores;

import java.util.Scanner;

public class Validaciones {
    public static boolean validarTexto(String texto){
        if(texto.trim().isEmpty()){
            System.out.println("**ERROR**\n- Por favor ingrese datos validos.");
            return false;
        }
        if(texto.length() < 3){
            System.out.println("**ERROR**\n- Coloque un minimo de 3 Caracteres en el nombre.");
            return false;
        }
        return true;
    }

    public static boolean validarClaveSencilla(String clave) {
        if (clave == null || clave.length() < 7) {
            return false;
        }

        if (!clave.matches(".*[A-Z].*")) {
            System.out.println("Falta una mayúscula en la clave.");
            return false;
        }
        if (!clave.matches(".*[a-z].*")) {
            System.out.println("Falta una minúscula en la clave.");
            return false;
        }
        if (!clave.matches(".*[^a-zA-Z0-9].*")) {
            System.out.println("Falta un carácter especial en la clave.");
            return false;
        }

        if (contarDigitos(clave) < 3) {
            System.out.println("Faltan 4 o más dígitos númericos en la clave.");
            return false;
        }

        return true;
    }

    private static long contarDigitos(String clave) {
        return clave.chars()
                .filter(Character::isDigit)
                .count();
    }

    public static boolean revisarCedula(long cedula) throws Exception{
        if (cedula <= 0) {
            System.out.println("**ERROR**\n- El valor de la cédula no puede ser cero o negativo.");
            return false;
        }

        String cedulaStr = String.valueOf(cedula);
        int longitud = cedulaStr.length();

        if (longitud < 8 || longitud > 12) {
            System.out.println("**ERROR**\n- La cédula debe tener entre 8 y 12 dígitos (actualmente tiene " + longitud + ").");
            return false;
        }

        return true;
    }

    public static double validarPrecio(Scanner rl){

        while (!rl.hasNextDouble()){
            System.out.println("Por favor ingrese un precio valido: ");
            rl.next();
        }

        double precio = rl.nextDouble();

        return precio;
    }

}
