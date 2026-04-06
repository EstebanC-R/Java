public class EjemploMatricesBuscar {
    public static void main(String[] args) {

        int[][] matrizEnteros = {
                {35, 90, 3, 1978},
                {15, 2020, 10, 5},
                {677, 127, 32767, 1999}
        };

        int elementoBuscar = 3;

        boolean encontrado = false;

        buscar: for(int i = 0; i < matrizEnteros.length; i++){
            for(int x = 0; x < matrizEnteros[i].length; x++){
                if(elementoBuscar == matrizEnteros[i][x]){
                    encontrado = true;
                    System.out.println("\n------------- ELEMENTO ENCONTRADO -------------");
                    System.out.println("- Fila = " + (i + 1));
                    System.out.println("- Columna = " + (x + 1));
                    System.out.println("- Valor = " + matrizEnteros[i][x]);
                    break buscar;
                }
            }
        }

        if(!encontrado){
            System.out.println("\nLo sentimos, no se ha encontrado el elemento " + elementoBuscar + ".");
        }
    }
}
