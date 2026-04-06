package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_6;

import java.util.Scanner;

public class Main {
    static String edad;
    public static void setEdad(int edad){
        if(edad <= 0){
            throw new IllegalArgumentException("Edad inválida");
        }else{
            System.out.println("Tienes " + edad + " años.");
        }
    }
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        System.out.println("Ingresa tú edad: ");
        String edadTexto = rl.nextLine();

        int edadNum = 0;

        try{
            edadNum = Integer.parseInt(edadTexto);
            setEdad(edadNum);
        }catch (NumberFormatException e){
            System.out.println("ERROR en el formato = " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("ERROR lógico: "+ e.getMessage());
        } finally {
            rl.close();
            System.out.println("Ha terminado la validación de edad.");
        }
    }
}
