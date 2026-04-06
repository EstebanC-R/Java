public class EjemploStringExtensionArchivo {
    static void main(String[] args) {
        String archivo = "alguna_imagen.jpeg";
        int i = archivo.lastIndexOf(".");
        System.out.println("archivo.length() = " + archivo.length());
        System.out.println("archivo.substring(14) = " + archivo.substring(archivo.length() - 4));
        System.out.println("archivo.(\".\") = " + archivo.substring(i + 1));
    }
}
