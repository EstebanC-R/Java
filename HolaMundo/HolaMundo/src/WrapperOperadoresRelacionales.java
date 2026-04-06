public class WrapperOperadoresRelacionales {
    static void main() {
        Integer num1 = Integer.valueOf(1000);
        Integer num2 = num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Son el mismo objeto? " + (num1 == num2));

        // * Al crearse un objeto o variable con la clase Integer wrapper lo que está pasando es que a num2 se le está
        //  Asignando el num1 por lo que comparten una misma instancia de la Clase wrapper, pero al reedeclarar num2 y ponerle
        //  1000 lo que está pasando es que internamente se está creando otra instancia que no coparte con num1
        num2 = 1000;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("Son el mismo objeto? " + (num1 == num2));

        // El equals compara es el valor
        System.out.println("Tienen el mismo valor? " + (num1.equals(num2)));
        System.out.println("Tienen el mismo valor? " + (num1.intValue() == num2.intValue()));

        num2 = 500;
        boolean condicion = num1 > num2;
        System.out.println("condicion = " + condicion);

        boolean condicion2 = num1.intValue() < num2.intValue();
        System.out.println("condicion2 = " + condicion2);

    }
}
