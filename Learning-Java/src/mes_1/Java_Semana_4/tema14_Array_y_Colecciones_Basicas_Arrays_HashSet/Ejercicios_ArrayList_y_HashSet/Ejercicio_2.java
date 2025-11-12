
package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] dias = new String[7];
        String respuesta;

        for(int i = 0; i < dias.length; i++){
            System.out.println("Ingresa el " + (i + 1) + " día de la semana: ");

            while(sc.hasNextInt()){
                System.out.println("Por favor ingresa el día de la semana en letras");
                sc.next();
            }
            respuesta = sc.next();
            dias[i] = respuesta;
        }

        System.out.println(Arrays.toString(dias));

        System.out.println("\nIngrese un número del 1 al 7: ");

        int numero = 0;

        while(true){
            while(!sc.hasNextInt()){
                System.out.println("Por favor ingrese un número como se le pidió: ");
                sc.next();
            }

            numero = sc.nextInt();

            if(numero >= 1 && numero <= 7){
                break;
            }else{
                System.out.println("Numero fuera de rango. Intente nuevamente: ");
            }
        }

        String dia = dias[numero - 1];
        System.out.println("Hoy es: " + dia + "\n");

        // Largo de letras por día.
        for(int i = 0; i < dias.length; i++){
            int cantidad = dias[i].length();
            if(cantidad > 6){
                System.out.println("El día " + dias[i] + " tiene " + cantidad + " de letras");
            }
        }

        System.out.println("Que día quiere verificar si esta en la semana?: ");


        while(sc.hasNextInt()){
            System.out.println("Por favor ingrese un dato correcto.");
            sc.next();
        }

        String encontrar = sc.next();
        boolean encontrado = false;

        for(int i = 0; i < dias.length; i++){
            if(dias[i].equalsIgnoreCase(encontrar)){
                System.out.println("Si, el día " + dias[i] + " si esta en la semana, es el día " + (i + 1) + ". :)");
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            System.out.println("Este día no se encuentra en la semana.");
        }




    }
}
