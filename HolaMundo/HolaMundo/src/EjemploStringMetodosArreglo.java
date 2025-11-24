public class EjemploStringMetodosArreglo {
    static void main(String[] args) {
        String trabalenguas = "trabalenguas";

        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray()); // Convierte a un arreglo el cual lo pone como un código único que lo identifica.

        char[] arreglo = trabalenguas.toCharArray();
        int largo = arreglo.length;

        for(var i = 0; i < largo; i++){
            System.out.println("Arreglo = " + arreglo[i]); // Se podría utilizar print para hacerlo horizontalmente sin que salte líneas, pero es más dinámico de esta forma.
        }

        System.out.println();
        System.out.println("trabalenguas = " + trabalenguas.split("a")); // Lo imprime con el Hash osea el código único, retornando un arreglo

        String[] arreglo2 = trabalenguas.split("a");
        int l = arreglo2.length;

        for(var i = 0; i < l; i++){
            System.out.println("Arreglo = " + arreglo2[i]);
        }

        System.out.println();

        String archivo = "alguna.imagen.jpeg";
        String[] archivoArr = archivo.split("\\."); // si se quita los backslash este no lo toma porque es un caracter reservado, por ello se le pone \\ para indicar un caracter en especial
        int larg = archivoArr.length;
        for(var i = 0; i < larg; i++){
            System.out.println("Arreglo = " + archivoArr[i]);
        }
        System.out.println();
        System.out.println("Extensión = " + archivoArr[larg - 1]);
    }
}
