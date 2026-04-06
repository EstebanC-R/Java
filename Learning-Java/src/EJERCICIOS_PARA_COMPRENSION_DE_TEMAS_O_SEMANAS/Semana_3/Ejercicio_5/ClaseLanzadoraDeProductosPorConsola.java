package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_5;

import java.util.HashSet;
import java.util.Scanner;

public class ClaseLanzadoraDeProductosPorConsola {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<ProductoPorConsola> inventario = new HashSet<>();

        String continuar;

        do {
            System.out.println("\n📦 Ingrese datos del producto:");

            System.out.print("Código: ");
            String codigo = sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Precio: ");
            double precio = Double.parseDouble(sc.nextLine());


            System.out.print("Stock: ");
            int stock = Integer.parseInt(sc.nextLine());

            ProductoPorConsola nuevo = new ProductoPorConsola(codigo, nombre, precio, stock);

            if (!inventario.add(nuevo)) {
                System.out.println("⚠️ Ya existe un producto con ese código. No se agregó.");
            } else {
                System.out.println("✅ Producto agregado correctamente.");
            }

            System.out.print("\n¿Desea agregar otro producto? (s/n): ");
            continuar = sc.nextLine().toLowerCase();

        } while (continuar.equals("s"));

        System.out.println("\n📋 Inventario final:");
        for (ProductoPorConsola p : inventario) {
            System.out.println(p);
        }

        sc.close();
    }
}