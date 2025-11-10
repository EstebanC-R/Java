package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_5;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        // 1. Creación de productos (cada uno con código, nombre, precio y stock)
        Productos p1 = new Productos("1312331", "Maicena", 2500.00, 14);
        Productos p2 = new Productos("123444", "Arroz Cielo", 3000.99, 150);
        Productos p3 = new Productos("44112311", "Lentejas", 3012.00, 50);
        Productos p4 = new Productos("41234", "Garbanzos", 1500.00, 20);
        Productos p5 = new Productos("41859", "Lasaña", 20000.00, 5);
        Productos p6 = new Productos("119198", "Paquete de Salchichas", 5000.00, 20);
        Productos p7 = new Productos("123444", "Lapiceros", 900.00, 400); // mismo código que p2

        // 2. Comparación de hashCodes entre p2 y p7 (deberían ser iguales)
        System.out.println("\nP2 y P7 tienen códigos iguales?");
        System.out.println("P2: " + p2.hashCode());
        System.out.println("P7: " + p7.hashCode() + "\n");

        // 3. Creación del HashSet para evitar duplicados por código
        HashSet<Productos> inventario = new HashSet<>();
        inventario.add(p1);
        inventario.add(p2); // se agrega primero
        inventario.add(p3);
        inventario.add(p4);
        inventario.add(p5);
        inventario.add(p6);
        inventario.add(p7); // se ignora porque p2 ya está y son iguales por código

        // 4. Mostrar inventario completo, destacando el producto con código duplicado
        System.out.println("Inventario en HashSet (Sin duplicados por código): ");
        for (Productos p : inventario) {
            if (p.getCodigo().equals("123444")) {
                System.out.println("→ Producto con código duplicado detectado:");
            }
            System.out.println(p);
        }

        // 5. Validación directa entre p2 y p7
        System.out.println("\n¿p2.equals(p7)? " + p2.equals(p7)); // debería ser true
        System.out.println("p2.hashCode(): " + p2.hashCode());
        System.out.println("p7.hashCode(): " + p7.hashCode());

        // 6. Verificación de presencia en el HashSet
        System.out.println("\n¿Está p2 en el inventario? " + inventario.contains(p2)); // true
        System.out.println("¿Está p7 en el inventario? " + inventario.contains(p7)); // también true, porque es igual a p2

        // 7. Mostrar nombre del producto con código duplicado
        System.out.println("\nProductos con código 123444 en el inventario:");
        for (Productos p : inventario) {
            if (p.getCodigo().equals("123444")) {
                System.out.println("→ " + p.getNombre()); // debería mostrar solo "Arroz Cielo"
            }
        }

        // 8. Mostrar total de productos únicos en el HashSet
        System.out.println("\nTotal de productos en el HashSet: " + inventario.size()); // debería ser 6
    }
}