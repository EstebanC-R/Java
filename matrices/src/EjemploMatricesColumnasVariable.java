public class EjemploMatricesColumnasVariable {
    public static void main(String[] args) {

        int[][] matriz = new int[3][];

        // # Esto es básicamente para definir el tamaño de cada columna.
        // # Entonces por ejemplo para la fila 1 osea la posición 0 sería matriz[3][2].
        // # Y para la fila 2 osea la posición 1 sería matriz[3][3].

        matriz[0] = new int[2];
        matriz[1] = new int[3];
        matriz[2] = new int[4];


        System.out.println("\nMatriz length (Número de Filas): " + matriz.length);
        System.out.println();
        System.out.println("Fila 0 length: " + matriz[0].length);
        System.out.println("Fila 1 length: " + matriz[1].length);
        System.out.println("Fila 2 length: " + matriz[2].length);


        for(int i = 0; i < matriz.length; i++){
            for(int x = 0; x < matriz[i].length; x++){
                matriz[i][x] = i * x;
            }
        }

        System.out.println("\n --------- TABLA VISUALMENTE --------- \n");
        for(int i = 0; i < matriz.length; i++){
            for(int x = 0; x < matriz[i].length; x++){
                System.out.printf("| %-10s |", matriz[i][x]);
            }
            System.out.println();
        }
    }
}
