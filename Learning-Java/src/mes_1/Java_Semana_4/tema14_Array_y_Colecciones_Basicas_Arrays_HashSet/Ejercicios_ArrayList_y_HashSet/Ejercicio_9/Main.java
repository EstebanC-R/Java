package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejercicio_9;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contacto> contactos = new ArrayList<>();
        HashSet<String> telefonos = new HashSet<>();

        Menu.menu(sc, contactos, telefonos);
    }
}
