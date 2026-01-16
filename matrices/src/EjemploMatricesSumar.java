public class EjemploMatricesSumar {
    public static void main(String[] args) {

        int[][] a = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] b = { {10, 20, 30}, {40, 50, 60}, {70, 80, 90} };

        int[][] suma = new int[3][3];

        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                suma[i][x] = a[i][x] + b[i][x];
            }
        }

        System.out.println();
        for(int i = 0; i < suma.length; i++){
            for(int x = 0; x < suma[i].length; x++){
                System.out.printf("|     %-5d  |", suma[i][x]);
            }
            System.out.println();
        }

    }
}
