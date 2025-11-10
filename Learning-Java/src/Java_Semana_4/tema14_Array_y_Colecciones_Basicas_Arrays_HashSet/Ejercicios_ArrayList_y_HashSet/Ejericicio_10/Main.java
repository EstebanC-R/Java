package Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejericicio_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        ArrayList<Producto> producto = new ArrayList<>();
        HashSet<String> codigo = new HashSet<>();
        String[] categorias = new String[5];
        categorias[0] = "Tecnología";
        categorias[1] = "Cocina";
        categorias[2] = "Alimentos";
        categorias[3] = "Bebidas";
        categorias[4] = "Disfraces";

        Menu.menu(rl, producto, codigo, categorias);
    }
}
