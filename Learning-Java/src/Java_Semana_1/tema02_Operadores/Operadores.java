package Java_Semana_1.tema02_Operadores;

public class Operadores {
    public static void main(String[] args){

        // OPERADORES ARITMÉTICOS
        System.out.println("\n==================OPERADORES ARITMÉTICOS=================");
        int a = 10, b = 3;
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3
        System.out.println("a % b = " + (a % b)); // 1

        // OPERADORES RELACIONALES
        System.out.println("\n==================OPERADORES RELACIONALES================");
        System.out.println("a == b → " + (a == b));   // false
        System.out.println("a != b → " + (a != b));   // true
        System.out.println("a > b  → " + (a > b));    // true
        System.out.println("a < b  → " + (a < b));    // false
        System.out.println("a >= b → " + (a >= b));   // true
        System.out.println("a <= b → " + (a <= b));   // false

        // OPERADORES LÓGICOS
        System.out.println("\n==================OPERADORES LÓGICOS=====================");
        boolean x = true;
        boolean y = false;

        System.out.println("x && y = " + (x && y)); // false → ambos deben ser true
        System.out.println("x || y = " + (x || y)); // true  → al menos uno es true
        System.out.println("!x = " + (!x));         // false → negación de true
        System.out.println("!y = " + (!y));         // true  → negación de false
    }
}
