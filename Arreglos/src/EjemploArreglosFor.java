import java.util.Arrays;

public class EjemploArreglosFor {
    public static void main(String[] args) {
        String[] productos = new String[7];

        int total = productos.length;

        productos[0] = "Kingston Pendrive 64G";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";

        Arrays.sort(productos);

        System.out.println("\n================ For Tradicional ================");
        for(int i = 0; i < total; i++){
            System.out.println("Para indice " + i + " : " + productos[i]);
        }

        System.out.println("\n================ Foreach ================");
        for(String prod : productos){
            System.out.println("Producto : " + prod);
        }

        System.out.println("\n================ While ================");
        int i = 0;
        while (i < total){
            System.out.println("Para indice " + i + " : " + productos[i]);
            i++;
        }

        System.out.println("\n================ Do While ================");
        i = 0;
        do {
            System.out.println("Para indice " + i + " : " + productos[i]);
            i++;
        }
        while (i < total);

        // ? ---------------------------------------------------------------------------

        int[] numeros = new int[10];
        int totalNums = numeros.length;

        for(int j = 0; j < totalNums; j++){
            numeros[j] = j * 3;
        }

        for(int j = 0; j < totalNums; j++){
            System.out.println("Números = " + numeros[j]);
        }

    }
}
