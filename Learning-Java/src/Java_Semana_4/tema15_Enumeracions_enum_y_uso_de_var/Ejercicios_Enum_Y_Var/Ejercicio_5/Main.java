package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var nombres = new ArrayList<String>();
        nombres.add("Ana");
        nombres.add("Luis");

        var estudiantes = new HashMap<Integer, String>();
        estudiantes.put(1, "Pedro");
        estudiantes.put(2, "María");

        for (var nombre : nombres) {
            System.out.println(nombre);
        }


        var rl = new Scanner(System.in);
        String input = rl.nextLine();
    }
}
