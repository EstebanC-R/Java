public class EjemploMatricesStringFor {

    public static void main(String[] args) {

        String[][] nombres = new String[3][2];

        // # Se pueden hacer tablas, como por ejemplo:
        nombres[0][0] = "NOMBRE";
        nombres[0][1] = "EDAD";

        nombres[1][0] = "Pepe";
        nombres[1][1] = "11 Años";  // ! Si se pone un comentario a este dato al imprimir en consola aparecerá "null"

        nombres[2][0] = "Milton";
        nombres[2][1] = "21 Años";


        System.out.println("\nIterando con for: ");
        for(int i = 0; i < nombres.length; i++){
            for(int x = 0; x < nombres[i].length; x++){
                System.out.printf("| %-10s |", nombres[i][x]);
            }
            System.out.println();
        }

        System.out.println("\nIterando con foreach: ");
        for(String[] fila  : nombres){
            for(String nombre : fila){
                System.out.printf("| %-10s |", nombre);
            }
            System.out.println();
        }

    }
}
