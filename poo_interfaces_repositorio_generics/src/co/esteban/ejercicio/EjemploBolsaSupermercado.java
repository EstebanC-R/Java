package co.esteban.ejercicio;

import co.esteban.ejercicio.lista.BolsaSupermercado;
import co.esteban.ejercicio.modelo.*;

public class EjemploBolsaSupermercado {
    public static void main(String[] args) {

        BolsaSupermercado<Fruta> bolsa1 = new BolsaSupermercado<>();

        bolsa1.addProducto(new Fruta("Manzana", 2000.00, 100, "Roja"));
        bolsa1.addProducto(new Fruta("Fresa", 4000.2, 500, "Roja"));
        bolsa1.addProducto(new Fruta("Piña", 4000.00, 1, "Amarilla"));
        bolsa1.addProducto(new Fruta("Mango", 2000.09, 400, "Amarillo pajarito"));
        bolsa1.addProducto(new Fruta("Naranja", 1000.09, 450, "Naranja"));


        /*System.out.println(" ================================================= ");
        for (Fruta f : bolsa1.getBolsa()) {
            System.out.println("Nombre: " + f.getNombre());
            System.out.println("Precio: " + f.getPrecio());
            System.out.println("Peso: " + f.getPeso());
            System.out.println("Color: " + f.getColor());
            System.out.println("-----------------------");
        }*/

        BolsaSupermercado<Lacteo> bolsa2 = new BolsaSupermercado<>();

        bolsa2.addProducto(new Lacteo("Leche", 3500.00, 100, 15));
        bolsa2.addProducto(new Lacteo("Choco Milk", 4000.2, 500, 12));
        bolsa2.addProducto(new Lacteo("Queso", 3200.00, 1, 23));
        bolsa2.addProducto(new Lacteo("Cuajada", 4300.09, 400, 35));
        bolsa2.addProducto(new Lacteo("Cheddar", 6000.09, 450, 10));


        /*System.out.println(" ================================================= ");
        for (Fruta f : bolsa1.getBolsa()) {
            System.out.println("Nombre: " + f.getNombre());
            System.out.println("Precio: " + f.getPrecio());
            System.out.println("Cantidad: " + f.getPeso());
            System.out.println("Proteínas: " + f.getColor());
            System.out.println("-----------------------");
        }*/

        BolsaSupermercado<Limpieza> bolsa3 = new BolsaSupermercado<>();

        bolsa3.addProducto(new Limpieza("Límpido", 7000.00, "Cloro liquido", 2));
        bolsa3.addProducto(new Limpieza("Fab", 21000.2, "Detergente en polvo", 1));
        bolsa3.addProducto(new Limpieza("Ariel", 17000.00, "Detergente en polvo", 1));
        bolsa3.addProducto(new Limpieza("Fabuloso", 10000.09, "Limpia piso, quita manchas.", 2));
        bolsa3.addProducto(new Limpieza("Límpido en gel", 28000.09, "Límpido, Quita Manchas, Quita Grasa y Componentes Toxicos al respirar.", 2));

        /*System.out.println(" ================================================= ");
        for (Fruta f : bolsa1.getBolsa()) {
            System.out.println("Nombre: " + f.getNombre());
            System.out.println("Precio: " + f.getPrecio());
            System.out.println("Componentes: " + f.getPeso());
            System.out.println("Litros: " + f.getColor());
            System.out.println("-----------------------");
        }*/

        BolsaSupermercado<NoPerecible> bolsa4 = new BolsaSupermercado<>();

        bolsa4.addProducto(new NoPerecible("Vinagre", 4000.00, 1, 20));
        bolsa4.addProducto(new NoPerecible("Aceite", 1100.2, 1, 100));
        bolsa4.addProducto(new NoPerecible("Sardina", 4200.00, 400, 500));
        bolsa4.addProducto(new NoPerecible("Miel", 38000.09, 600, 1000));
        bolsa4.addProducto(new NoPerecible("Atún", 4400.09, 400, 600));

        /*System.out.println(" ================================================= ");
        for (Fruta f : bolsa1.getBolsa()) {
            System.out.println("Nombre: " + f.getNombre());
            System.out.println("Precio: " + f.getPrecio());
            System.out.println("Contenido: " + f.getPeso());
            System.out.println("Calorías: " + f.getColor());
            System.out.println("-----------------------");
        }*/


        // % LOS COMENTARIOS SON SIMPLEMENTE PARA CUMPLIR CON EL EJERCICIO DE
        // % EVITAR HACER CAST NI TAMPOCO UTILIZAR EL toString(), EL MÉTODO imprimirProductos();
        // % SE ENCARGA DE ESTO DE UNA FORMA MÁS DINÁMICA Y EN TORNO A ALGO REAL.


        imprimirProductos(bolsa1);
        imprimirProductos(bolsa2);
        imprimirProductos(bolsa3);
        imprimirProductos(bolsa4);

    }

    public static <T> void imprimirProductos(BolsaSupermercado<T> bolsa){
        int num = 1;
        for(T p : bolsa.getBolsa()){
            if(num < 2){
                System.out.println("\n ========================= " + p.getClass().getSimpleName() + " =========================");
                num++;
            }
            System.out.println(p);
            System.out.println("-----------------------------");
        }
    }
}
