import java.util.Arrays;

public class EjemploArreglosForInverso {
    public static void main(String[] args) {
        // $ String[] productos = new String[7];
        String[] productos = {"Kingston Pendrive 64G", "Samsung Galaxy", "Disco Duro SSD Samsung Externo", "Asus Notebook", "Macbook Air", "Chromecast 4ta generación", "Bicicleta Oxford"};

        int total = productos.length;

        /* % productos[0] = "Kingston Pendrive 64G";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";
        */

        Arrays.sort(productos);

        System.out.println("\n================ For Tradicional ================");
        for(int i = 0; i < total; i++){
            System.out.println("Para indice " + i + " : " + productos[i]);
        }

        System.out.println("\n================ For Tradicional a la Inversa ================");
        for(int i = 0; i < total; i++){
            System.out.println("Para i: " + (total - 1 - i) + " valor: " + productos[total - 1 - i]);
        }

        System.out.println("\n================ For Tradicional a la Inversa 2 ================");
        for(int i = total - 1; i >= 0; i--){
            System.out.println("Para i: " + i + " valor: " + productos[i]);
        }
    }
}
