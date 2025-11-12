package mes_1.Java_Semana_1.tema04_scanner_Entrada_y_Salida_de_Datos;

public class Scanner {
    public static void main(String[] args){

        //Scanner es parecido al readline de javascript
        java.util.Scanner rl = new java.util.Scanner(System.in);

        System.out.println("Ingresa tu nombre: ");
        String nombre = rl.nextLine();

        System.out.println("Ahora ingresa tu edad: ");
        int edad = rl.nextInt();

        System.out.println("Hola " + nombre + " Como estas?, asi que tienes " + edad + " años? todavia te falta mucho por vivir :)");
    }
}
