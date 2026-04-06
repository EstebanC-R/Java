package co.esteban.ejercicio2;

import co.esteban.ejercicio2.lista.CajaAlmacen;
import co.esteban.ejercicio2.modelo.Electronico;
import co.esteban.ejercicio2.modelo.Libro;
import co.esteban.ejercicio2.modelo.Mueble;
import co.esteban.ejercicio2.modelo.Ropa;

public class EjemploArticulosCaja {
    public static void main(String[] args) {

        CajaAlmacen<Electronico> electronicoCajaAlmacen = new CajaAlmacen<>();

        electronicoCajaAlmacen.addArticulo(new Electronico("Lavadora", 1200000, "Mabe", 6))
                .addArticulo(new Electronico("Licuadora", 500000, "Trish", 3))
                .addArticulo(new Electronico("Microondas", 423000, "Cassio", 2))
                .addArticulo(new Electronico("Cafetera", 530000, "CoffeStore", 12))
                .addArticulo(new Electronico("Nevera", 3000000, "Hgmm", 21));

        System.out.println("\n ============================ " + Electronico.class.getSimpleName() + " ============================");
        for(Electronico e : electronicoCajaAlmacen.getCaja()){
            System.out.println("-------------------------------------");
            System.out.println("- Nombre: " + e.getNombre());
            System.out.println("- Precio: " + e.getPrecio());
            System.out.println("- Marca: " + e.getMarca());
            System.out.println("- Meses de Garantía: " + e.getGarantiaMeses());
        }
        System.out.println("==================================================");


        CajaAlmacen<Ropa> ropaCajaAlmacen = new CajaAlmacen<>();

        ropaCajaAlmacen.addArticulo(new Ropa("Camisa", 56000, "X", "Lino"))
                .addArticulo(new Ropa("Pantalones", 100000, "M", "Algodón"))
                .addArticulo(new Ropa("Camisilla", 23000, "S", "Seda"))
                .addArticulo(new Ropa("Sudadera", 68000, "L", "Gamuza"))
                .addArticulo(new Ropa("Chaqueta", 200000, "Xl", "Retajos"));

        System.out.println("\n ============================ " + Ropa.class.getSimpleName() + " ============================");
        for(Ropa r : ropaCajaAlmacen.getCaja()){
            System.out.println("-------------------------------------");
            System.out.println("- Nombre: " + r.getNombre());
            System.out.println("- Precio: " + r.getPrecio());
            System.out.println("- Talla: " + r.getTalla());
            System.out.println("- Material: " + r.getMaterial());
        }
        System.out.println("==================================================");

        CajaAlmacen<Mueble> muebleCajaAlmacen = new CajaAlmacen<>();

        muebleCajaAlmacen.addArticulo(new Mueble("Armario", 56000, 70, true))
                .addArticulo(new Mueble("Gabinetes de cocina", 100000, 40, true))
                .addArticulo(new Mueble("Mesa", 23000, 100, true))
                .addArticulo(new Mueble("Banca", 80000, 20, false))
                .addArticulo(new Mueble("Silla", 100000, 40, false));

        System.out.println("\n ============================ " + Mueble.class.getSimpleName() + " ============================");
        for(Mueble m : muebleCajaAlmacen.getCaja()){
            System.out.println("-------------------------------------");
            System.out.println("- Nombre: " + m.getNombre());
            System.out.println("- Precio: " + m.getPrecio());
            System.out.println("- Peso: " + m.getPeso());
            System.out.println("- Requiere Armado: " + m.isRequiereArmado());
        }
        System.out.println("==================================================");

        CajaAlmacen<Libro> libroCajaAlmacen = new CajaAlmacen<>();

        libroCajaAlmacen.addArticulo(new Libro("Cuervos en el cielo", 48000, "Milton Castaño", 200))
                .addArticulo(new Libro("Una escalera al cielo", 50000, "Mario Mendoza", 160))
                .addArticulo(new Libro("Cien años de soledad", 60000, "Gabriel Garcia Marquez", 300))
                .addArticulo(new Libro("Un viaje al centro de la tierra", 30000, "Julio Verne", 87))
                .addArticulo(new Libro("Satanás", 53000, "Mario mendoza", 230));

        System.out.println("\n ============================ " + Libro.class.getSimpleName() + " ============================");
        for(Libro l : libroCajaAlmacen.getCaja()){
            System.out.println("-------------------------------------");
            System.out.println("- Nombre: " + l.getNombre());
            System.out.println("- Precio: " + l.getPrecio());
            System.out.println("- Autor: " + l.getAutor());
            System.out.println("- Paginas: " + l.getPaginas());
        }
        System.out.println("==================================================");

    }
}
