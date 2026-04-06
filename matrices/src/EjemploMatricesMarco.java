public class EjemploMatricesMarco {

    public static void main(String[] args) {
        int[][] a = new int[5][5];


        // # || i + x == a.length - 1 (La otra diagonal para hacer una X en medio).
        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                if(i == 0 || i == a.length - 1 || x == 0 || x == a[i].length - 1 || i == x){
                    a[i][x] = 1;
                }
            }
        }

        System.out.println("\n --------------------- Matriz --------------------- ");
        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                System.out.printf(" %-5d ", a[i][x]);
            }
            System.out.println();
        }
    }
}
