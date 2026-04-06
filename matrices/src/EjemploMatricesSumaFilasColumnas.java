public class EjemploMatricesSumaFilasColumnas {
    public static void main(String[] args) {
        int sumaFila, sumaColumna;
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for(int i = 0; i < a.length; i++){
            sumaFila = 0;
            sumaColumna = 0;
            for(int x = 0; x < a[i].length; x++){
                sumaFila += a[i][x];
                sumaColumna += a[x][i];
            }

            System.out.println("\nTotal Fila " + i + " : " + sumaFila);
            System.out.println("Total Columna " + i + " : " + sumaColumna);
        }

    }
}
