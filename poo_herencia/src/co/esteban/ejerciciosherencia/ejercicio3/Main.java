package co.esteban.ejerciciosherencia.ejercicio3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // ===== Clientes =====
        Cliente cliente1 = new Cliente(
                "Milton", "Castaño",
                "Cr 42 D Cl 107 A-33",
                "1048265482"
        );

        Cliente cliente2 = new Cliente(
                "Esteban", "Marin",
                "Cr 42 D Cl 109 A-33",
                "442312344"
        );

        // ===== Vendedores =====
        Vendedor vendedor1 = new Vendedor(
                "Yony", "Castaño",
                "Tienda-Yony Cr 80 D Cl 45 A-11",
                "8129922",
                "123331444"
        );

        Vendedor vendedor2 = new Vendedor(
                "Andres", "Torres",
                "Tienda-Andres Cr 80 D Cl 45 A-11",
                "8122229922",
                "4324555"
        );

        // ===== Productos =====
        NoPerecedero productoNoPerecible1 = new NoPerecedero("Atún", 4000.00, 400, 1000);

        Limpieza productoLimpieza1 = new Limpieza("Fab", 3000, "Jabón y Desinfectante", 2);

        Perecedero productoPerecedero1 = null;

        try {
            String fechaVencimiento = "12/02/2026";
            SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sf.parse(fechaVencimiento);

            productoPerecedero1 = new Perecedero("Arroz", 2500, 350, 600, fecha);

        } catch (ParseException e) {
            System.out.println("Error en la fecha: " + e.getMessage());
            System.exit(-1);
        }

        // ===== Factura =====
        Factura factura1 = new Factura(cliente1, vendedor1);

        factura1.agregarProducto(productoNoPerecible1);
        factura1.agregarProducto(productoPerecedero1);
        factura1.agregarProducto(productoLimpieza1);

        // ===== Mostrar factura =====
        System.out.println(factura1);
    }
}
