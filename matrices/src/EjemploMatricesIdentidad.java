public class EjemploMatricesIdentidad {

    public static void main(String[] args) {
        int[][] a = new int[5][5];

        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                if(i == x){
                    a[i][x] = 1;
                }
            }
        }

        System.out.println("\n --------------------- Matriz --------------------- ");
        for(int i = 0; i < a.length; i++){
            for(int x = 0; x < a[i].length; x++){
                System.out.printf("| %-5d |", a[i][x]);
            }
            System.out.println();
        }
    }
}
