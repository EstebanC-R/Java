import java.util.Arrays;
import java.util.Collections;

public class EjemploArreglosForInversoMutable {
    public static void arregloInverso(String[] arreglo){
        int total = arreglo.length;
        for(int i = 0; i < total / 2; i++){
            String actual = arreglo[i];
            String inverso = arreglo[total - 1 - i];
            arreglo[i] = inverso;
            arreglo[total - 1 - i] = actual;
        }
    }
    public static void main(String[] args) {
        String[] productos = {"Kingston Pendrive 64G", "Samsung Galaxy", "Disco Duro SSD Samsung Externo", "Asus Notebook", "Macbook Air", "Chromecast 4ta generación", "Bicicleta Oxford"};

        int total = productos.length;

        Arrays.sort(productos);
        arregloInverso(productos);

        // ? Collections.reverse(Arrays.asList(productos));

        System.out.println("\n================ For Tradicional ================");
        for(int i = 0; i < total; i++){
            System.out.println("Para indice " + i + " : " + productos[i]);
        }

    }
}
