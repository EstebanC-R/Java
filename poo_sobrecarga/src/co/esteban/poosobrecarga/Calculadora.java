package co.esteban.poosobrecarga;

/*
    ! La sobrecarga de métodos permite definir varios métodos con el mismo nombre,
    ! pero con diferentes firmas (cantidad y/o tipos de parámetros).
    ! Lo importante es el tipo y número de los argumentos, no el nombre de las variables.
    ? Ejemplo:
        % sumar(int a, int b)        -> recibe dos enteros
        # sumar(float x, float y)    -> recibe dos flotantes
        * sumar(int a, float b)      -> mezcla int y float
        $ sumar(int a, int b, int c) -> tres enteros
    ! El compilador elige automáticamente cuál método usar según los argumentos
    ! que se pasen en la llamada. Así se reutiliza un mismo concepto ("sumar")
    ! adaptado a distintos casos.
*/

public class Calculadora {

    private Calculadora() {
    }

    public static int sumar(int a, int b){
        return a + b;
    }

    public static int sumar(int... argumentos){
        int total = 0;
        for(int i : argumentos){
            total += i;
        }
        return total;
    }

    /*
        $ Estos métodos muestran cómo funciona la sobrecarga con varargs:

        ! - public float sumar(float a, int... argumentos):
        %   Recibe un número float inicial y una cantidad variable de enteros.
        %   Java agrupa los int en un arreglo interno y los suma al valor base.

        ! - public double sumar(double... varargs):
        %   Recibe directamente una cantidad variable de doubles.
        %   Todos los valores se almacenan en un arreglo interno y se recorren
        ?   para calcular la suma total.

        $ En ambos casos, el uso de varargs (tipo... nombre) permite invocar
        $ el método con múltiples argumentos separados por comas, sin necesidad
        $ de crear un arreglo manual por ejemplo double[] lista.
    */

    public static float sumar(float a, int... argumentos){
        float total = a;
        for(int i : argumentos){
            total += i;
        }
        return total;
    }

    public static double sumar(double... varargs){
        double total = 0;
        for(double i : varargs){
            total += i;
        }

        return total;
    }

    public static float sumar(float x, float y){
        return x + y;
    }

    public static float sumar(int i, float j){
        return i + j;
    }

    public static float sumar(float i, int j){
        return i + j;
    }

    public static double sumar(double a, double b){
        return a + b;
    }

    public static int sumar(String a, String b){
        int resultado;
        try {
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
        } catch (NumberFormatException e){
            System.out.println("Mensaje = " + e.getMessage());
            resultado = 0;
        }

        return resultado;
    }

    public static int sumar(int a, int b, int c){
        return a + b + c;
    }
}


