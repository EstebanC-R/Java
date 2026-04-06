package co.esteban.poosobrecarga;

import static co.esteban.poosobrecarga.Calculadora.*;

public class EjemploSobrecarga {
    public static void main(String[] args) {

    /*
        ! Cuando se invoca una sobrecarga con distintos tipos de datos,
        ! Java aplica reglas de conversión implícita (promoción de tipos).
        # Ejemplo: si se llama a sumar(5, 3.5) sin la 'F', el 3.5 se interpreta
        # como double por defecto. Como no existe un método sumar(int, double),
        # el compilador convierte automáticamente el int a double y selecciona
        * sumar(double, double), porque es la opción más cercana y válida.

        $ En resumen: Java siempre busca la firma más compatible, aplicando
        $ conversiones automáticas cuando es necesario.
    */

        // % Al ponerse el constructor en private en lugar de public,
        // % automáticamente este no se le puede instanciar, marcando error.
        // ! Calculadora cal = new Calculadora();

        System.out.printf("Sumar int    -  int = " + sumar(10, 5));
        System.out.printf("Sumar float  -  float = " + sumar(10F, 5F));
        System.out.printf("Sumar int    -  float = " + sumar(10, 5F));
        System.out.printf("Sumar float  -  int = " + sumar(10F, 5));
        System.out.printf("Sumar double -  double = " + sumar(10.2, 5.1));
        System.out.printf("Sumar String -  String = " + sumar("10", "5"));
        System.out.printf("Sumar int    -  int - int = " + sumar(10, 5, 5));

        /*
            ? Aquí se utiliza una sobrecarga con parámetros tipo varargs (ej. double... valores),
            ? lo que permite pasar una cantidad variable de argumentos sin usar un arreglo explícito.
            ? A diferencia de declarar double[], los varargs permiten invocar el método con múltiples
            ? valores separados por comas, y Java los agrupa automáticamente en un arreglo interno.
        */

        System.out.println("Sumar int^4 = " + sumar(10, 5, 3, 4));
        System.out.println("Sumar int^5 = " + sumar(10, 5, 3, 4, 2, 20));
        System.out.println("Sumar float + n int = " + sumar(10F, 10, 5, 3, 4, 2, 20));
        System.out.println("Sumar 3 double o más = " + sumar(10, 10.3, 10.3, 10.1));


        // ? Cuando se pasan argumentos cuyo tipo no coincide con ninguna sobrecarga,
        // ? el compilador aplica promoción de tipos para encontrar la firma más cercana.
        // * En el caso de long, como no existe sumar(long, long), Java convierte los
        // * valores a double (o float si fuera más adecuado) y selecciona sumar(double, double).
        // * Esto ocurre porque double es el tipo más amplio y compatible disponible,
        // * garantizando que la operación pueda realizarse sin error de compilación.
        // ! Esto pasa con el resto de combinaciones, va a seleccionar las que esten más cercas unas de otras.
        System.out.println("Sumar long   -  long = " + sumar(10L, 10L));

        // # En Java los caracteres tienen un valor numérico Unicode.
        // # Al sumarlos con enteros, se convierten automáticamente en su código.
        // # Ejemplo: '@' equivale a 64, por lo que 10 + '@' da 74.
        System.out.println("Sumar int    -  String = " + sumar(10, '@'));
    }
}
