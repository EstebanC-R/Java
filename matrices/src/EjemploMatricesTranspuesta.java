public class EjemploMatricesTranspuesta {
    public static void main(String[] args) {

        int[][] matriz = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("\nMatriz Original = ");

        for(int i = 1; i < matriz.length; i++){
            for(int x = 0; x < matriz[i].length; x++){
                System.out.printf("| %d |", matriz[i][x]);
            }
            System.out.println();
        }

        int aux;
        for(int i = 0; i < matriz.length; i++){
            for(int x = 0; x < i; x++){
                aux = matriz[i][x];
                matriz[i][x] = matriz[x][i];
                matriz[x][i] = aux;
            }
        }

        System.out.println("\nMatriz Transpuesta = ");

        for(int i = 0; i < matriz.length; i++){
            for(int x = 0; x < matriz[i].length; x++){
                System.out.printf("| %d |", matriz[i][x]);
            }
            System.out.println();
        }
    }
}
