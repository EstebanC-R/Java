import java.util.Arrays;

public class EjemploArreglosForOrdenamientoBurbuja {
    public static void arregloInverso(String[] arreglo){
        int total = arreglo.length;
        for(int i = 0; i < total / 2; i++){
            String actual = arreglo[i];
            String inverso = arreglo[total - 1 - i];
            arreglo[i] = inverso;
            arreglo[total - 1 - i] = actual;
        }
    }

    public static void sortBurbuja(Object[] arreglo){
        int total = arreglo.length;
        int contador = 0;

        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1 - i; j++){
                if( ((Comparable) arreglo[j + 1]).compareTo(arreglo[j]) > 0 ){
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;
                }
                contador++;
            }
        }
        System.out.println("contador = " + contador);
    }

    public static void main(String[] args) {
        String[] productos = {"Kingston Pendrive 64G", "Samsung Galaxy", "Disco Duro SSD Samsung Externo", "Asus Notebook", "Macbook Air", "Chromecast 4ta generación", "Bicicleta Oxford"};

        int total = productos.length;

        sortBurbuja(productos);

        System.out.println("\n================ For Tradicional ================");
        for(int i = 0; i < total; i++){
            System.out.println("Para indice " + i + " : " + productos[i]);
        }

        Integer[] numeros = new Integer[4];

        numeros[0] = 10;
        numeros[1] = 22;
        numeros[2] = -3;
        numeros[3] = 4;

        sortBurbuja(numeros);

        for(int i = 0; i < numeros.length; i++){
            System.out.println("i = " + i + " : " + numeros[i]);
        }
    }
}
