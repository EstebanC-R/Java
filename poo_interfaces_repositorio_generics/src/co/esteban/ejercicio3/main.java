package co.esteban.ejercicio3;

import co.esteban.ejercicio3.lista.ImpresoraInventario;
import co.esteban.ejercicio3.modelo.*;
import co.esteban.ejercicio3.lista.Inventario;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {


        Inventario<Electronico2> electronico2Inventario = new Inventario<>();

        electronico2Inventario.addInventario(new Electronico2("Nevera", 3000000, "Nevecon", 12))
                .addInventario(new Electronico2("Microondas", 400000, "Samsung", 6))
                .addInventario(new Electronico2("Cafetera", 345000, "Immusa", 3));

        for(Electronico2 e : electronico2Inventario.getInventario()){
            System.out.println("\n- Nombre: " + e.getNombre());
            System.out.println("- Precio: " + e.getPrecio());
            System.out.println("- Marca: " + e.getMarca());
            System.out.println("- Meses de Garantía: " + e.getGarantiaMeses());
        }

        Inventario<Ropa2> ropa2Inventario = new Inventario<>();
        ropa2Inventario.addInventario(new Ropa2("Camisa", 60000, "M", "Seda"))
                .addInventario(new Ropa2("Pantalón", 100000, "32", "Retales de tela"))
                .addInventario(new Ropa2("Chaqueta", 140000, "M", "Algodón"));

        for(Ropa2 e : ropa2Inventario.getInventario()){
            System.out.println("\n- Nombre: " + e.getNombre());
            System.out.println("- Precio: " + e.getPrecio());
            System.out.println("- Talla: " + e.getTalla());
            System.out.println("- Material: " + e.getMaterial());
        }

        System.out.println("\nEl total del Carro de electrónicos es: " + electronico2Inventario.calcularTotal());
        System.out.println("El total del Carro de ropa es: " + ropa2Inventario.calcularTotal());


        System.out.println("\n\n====================================== Con List ===================================");

        List<Electronico2> electronico2List = new ArrayList<>();
        electronico2List.add(new Electronico2("Nevera", 3000000, "Nevecon", 12));
        electronico2List.add(new Electronico2("Microondas", 400000, "Samsung", 6));
        electronico2List.add(new Electronico2("Cafetera", 345000, "Immusa", 3));

        // Lista de ropa
        List<Ropa2> ropa2List = new ArrayList<>();
        ropa2List.add(new Ropa2("Camisa", 60000, "M", "Seda"));
        ropa2List.add(new Ropa2("Pantalón", 100000, "32", "Retales de tela"));
        ropa2List.add(new Ropa2("Chaqueta", 140000, "M", "Algodón"));

        // Lista de libros
        List<Libro2> libro2List = new ArrayList<>();
        libro2List.add(new Libro2("El Quijote", 25000, "Cervantes", 100));
        libro2List.add(new Libro2("1984", 30000, "George Orwell", 80));
        libro2List.add(new Libro2("Cien años de soledad", 40000, "Gabriel García Márquez", 200));

        // % Ahora sí llamamos al método imprimir
        System.out.println("=== Inventario de Electrónicos ===");
        ImpresoraInventario.imprimir(electronico2List);

        System.out.println("=== Inventario de Ropa ===");
        ImpresoraInventario.imprimir(ropa2List);

        System.out.println("=== Inventario de Libros ===");
        ImpresoraInventario.imprimir(libro2List);



    }
}
