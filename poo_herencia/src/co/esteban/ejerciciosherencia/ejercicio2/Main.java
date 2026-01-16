package co.esteban.ejerciciosherencia.ejercicio2;

public class Main {
    public static void main(String[] args) {

        Producto[] productos = new Producto[8];

        Lacteo lacteo1 = new Lacteo("Leche entera", 3400.0, 10, 25);
        Lacteo lacteo2 = new Lacteo("Leche deslactosada", 5000.0, 16, 31);

        Fruta fruta1 = new Fruta("Fresa", 3400.0, 0.5, "Rojo");
        Fruta fruta2 = new Fruta("Manza", 2000.0, 1, "Verde");

        Limpieza limpieza1 = new Limpieza("Clorox", 3000, "Cloro y vinagre", 2);
        Limpieza limpieza2 = new Limpieza("Fabuloso", 4000.0, "Escencias florales, desinfectante y desengrasante", 1);

        NoPerecible noPerecible1 = new NoPerecible("Miel", 40000, 400, 1200);
        NoPerecible noPerecible2 = new NoPerecible("Atún", 6000, 500, 200);

        productos[0] = lacteo1;
        productos[1] = lacteo2;
        productos[2] = fruta1;
        productos[3] = fruta2;
        productos[4] = limpieza1;
        productos[5] = limpieza2;
        productos[6] = noPerecible1;
        productos[7] = noPerecible2;

        for(int i = 0; i < productos.length; i++){
            if(productos[i] instanceof Lacteo){
                System.out.println("\n ========================== Producto Lácteo ==========================");
                System.out.printf("- %-15s : %d\n", "Cantidad", ((Lacteo) productos[i]).getCantidad());
                System.out.printf("- %-15s : %d\n", "Proteínas", ((Lacteo) productos[i]).getProteinas());
            }

            if(productos[i] instanceof Fruta){
                System.out.println("\n ========================== Producto Fruta ==========================");
                System.out.printf("- %-15s : %.2f\n", "Peso(kg)", ((Fruta) productos[i]).getPeso());
                System.out.printf("- %-15s : %s\n", "Color", ((Fruta) productos[i]).getColor());
            }

            if(productos[i] instanceof Limpieza){
                System.out.println("\n ========================== Producto Limpieza ==========================");
                System.out.printf("- %-15s : %s\n", "Componentes", ((Limpieza) productos[i]).getComponentes());
                System.out.printf("- %-15s : %.2f\n", "Litros", ((Limpieza) productos[i]).getLitros());
            }

            if(productos[i] instanceof NoPerecible){
                System.out.println("\n ========================== Producto No Perecedero ==========================");
                System.out.printf("- %-15s : %d\n", "Contenido", ((NoPerecible) productos[i]).getContenido());
                System.out.printf("- %-15s : %d\n", "Calorías", ((NoPerecible) productos[i]).getCalorias());
            }

            System.out.printf("- %-15s : %s\n", "Nombre", productos[i].getNombre());
            System.out.printf("- %-15s : %.2f\n", "Precio", productos[i].getPrecio());
            System.out.println();
        }
    }
}
