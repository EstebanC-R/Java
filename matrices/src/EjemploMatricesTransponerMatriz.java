public class EjemploMatricesTransponerMatriz {

    public static void main(String[] args) {
        int[][] a, b;

        a = new int[8][4];
        b = new int[4][8];

        System.out.println("\nMatriz Original A = ");
        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                a[i][x] = i + x * 3;
                System.out.print(a[i][x] + "\t");
            }
            System.out.println();
        }

        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                b[x][i] = a[i][x];
            }
        }

        System.out.println("\nLa matriz transpuesta B = ");
        for(int i = 0; i < b.length; i++){
            for(int x = 0; x < b[i].length; x++){
                System.out.print(b[i][x] + "\t");
            }
            System.out.println();
        }
    }
}
