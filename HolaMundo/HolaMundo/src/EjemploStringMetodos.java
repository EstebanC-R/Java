public class EjemploStringMetodos {
    static void main(String[] args) {
        // Antes recordemos que cuando se declara un string, este es inmutable.
        // Solo que cuando se modifica este crea una nueva instancia de String, y es el que devuelve
        // sin afectar al String original.

        String nombre = "Milton";

        // Secuencia de caracteres totales.
        System.out.println("nombre.length() = " + nombre.length());

        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());

        System.out.println("nombre.equals(\"Milton\") = " + nombre.equals("Milton"));
        System.out.println("nombre.equals(\"milton\") = " + nombre.equals("milton"));
        System.out.println("nombre.equalsIgnoreCase(\"Milton\") = " + nombre.equalsIgnoreCase("Milton"));

        // Compara con unicode, si es 0 entonces es que son iguales, pero si es > 0 significa que va despues del segundo,
        // < 0 siignifica que va antes que el segundo.
        System.out.println("nombre.compareTo(\"Milton\") = " + nombre.compareTo("Milton"));
        System.out.println("nombre.compareTo(\"Milton\") = " + nombre.compareTo("Esteban"));

        // CharAt admite por posiciones, empezando desde 0
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(1) = " + nombre.charAt(1));
        System.out.println("nombre.charAt(nombre.length() - 1) = " + nombre.charAt(nombre.length() - 1)); // Ultimo valor

        System.out.println("nombre.substring(3) = " + nombre.substring(3)); // Toma desde la posición dada en adelante
        System.out.println("nombre.substring(0) = " + nombre.substring(0));
        System.out.println("nombre.substring(1, 4) = " + nombre.substring(1, 4)); // Rango hasta donde se quiere tomar, la posición 4 no se incluye, osea que va hasta la posición 3, esto a no ser que sea la ultima posición
        System.out.println("nombre.substring(5) = " + nombre.substring(5));
        System.out.println("nombre.substring(nombre.length() - 1) = " + nombre.substring(nombre.length() - 1));

        
        String trabalenguas = "trabalenguas";
        System.out.println("trabalenguas.replace(\"a\", \"_\") = " + trabalenguas.replace("a", "_"));
        System.out.println("trabalenguas = " + trabalenguas); // Inmutabilidad


        System.out.println("trabalenguas.indexOf(\"a\") = " + trabalenguas.indexOf("a")); // Puede recibir un int o character. Retorna la posición de la primera coincidencia.
        System.out.println("trabalenguas.lastIndexOf(\"a\") = " + trabalenguas.lastIndexOf("a")); // Busca la última coincidencia
        System.out.println("trabalenguas.indexOf(\"z\") = " + trabalenguas.indexOf("lenguas")); // Si no se encuentra dentro una coincidencia retorna un número <
        System.out.println("trabalenguas.contains(\"t\") = " + trabalenguas.contains("lenguas")); // solo acepta un String no un solo caracter ' ' comillas simples

        System.out.println("trabalenguas.startsWith(\"traba\") = " + trabalenguas.startsWith("traba")); // Retorna true o false dependiendo si inicia con o no
        System.out.println("trabalenguas.startsWith(\"Lengua\") = " + trabalenguas.startsWith("Lengua"));
        System.out.println("trabalenguas.endsWith(\"tr\") = " + trabalenguas.endsWith("tr")); // Lo mismo que startWith pero este es con el final, termina con
        System.out.println("trabalenguas.endsWith(\"as\") = " + trabalenguas.endsWith("as"));

        System.out.println("  trabalenguas  ");
        System.out.println("  trabalenguas  ".trim()); // Quita los espacios
    }
}
