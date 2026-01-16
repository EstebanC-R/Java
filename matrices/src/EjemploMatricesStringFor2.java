public class EjemploMatricesStringFor2 {

    public static void main(String[] args) {

        // ! Solo se utiliza cuando se sabe los datos a insertar.
        String[][] nombres = { {"NOMBRE", "EDAD"}, {"Pepe", "11 Años"}, {"Milton", "21 Años"} };

        // # Se pueden hacer tablas, como por ejemplo:
        System.out.println();
        for(String[] fila  : nombres){
            for(String nombre : fila){
                System.out.printf("| %-10s |", nombre);
            }
            System.out.println();
        }

    }
}
