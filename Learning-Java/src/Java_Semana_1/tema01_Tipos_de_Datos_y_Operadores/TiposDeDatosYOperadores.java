package Java_Semana_1.tema01_Tipos_de_Datos_y_Operadores;

public class TiposDeDatosYOperadores {
    public static void main(String[] args){

        // EJERCICIO 2 Tipos de variables
        int edad = 21;
        double estatura = 1.60;
        boolean estudiante = true;
        char genero = 'M';
        String nombre = "Milton";

        System.out.println("\n==============Tipos de Datos: ==============");
        System.out.printf("String   : Nombre - %s\n", nombre);
        System.out.printf("int      : Edad - %02d años\n", edad);
        System.out.printf("double   : Estatura - %.2f metros\n", estatura);
        System.out.printf("Booleano : Estudiante - %b\n", estudiante);
        System.out.printf("Char     : Genero - %c\n", genero);

        // Si se quiere saber más de printf buscar el OneNote o Buscar por cuenta propia
    }
}
