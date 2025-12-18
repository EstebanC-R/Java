public class WrapperBoolean {
    static void main() {
        // * A diferencia de los números, los valores Boolean funcionan de otra manera.
        // * En los Integer, cada instancia puede representar un valor distinto y se compara
        // * la identidad de cada objeto. En cambio, un Boolean solo indica si es true o false,
        // * sin importar si proviene de una instancia diferente. Lo relevante es el valor lógico,
        // * no la referencia del objeto.


        Integer num1, num2;
        num1 = 1;
        num2 = 2;

        boolean primBoolean = num1 > num2; // false
        Boolean objBoolean = Boolean.valueOf(primBoolean);
        Boolean objBoolean2 = Boolean.valueOf("false");
        Boolean objBoolean3 = true;

        System.out.println("primBoolean = " + primBoolean);
        System.out.println("objBoolean = " + objBoolean);
        System.out.println("objBoolean2 = " + objBoolean2);

        System.out.println("Comparando dos objetos boolean: " + (objBoolean == objBoolean2));
        System.out.println("Comparando dos objetos boolean: " + (objBoolean.equals(objBoolean2)));
        System.out.println("Comparando dos objetos boolean: " + (objBoolean2 == objBoolean3));
        System.out.println("Comparando dos objetos boolean: " + (objBoolean == objBoolean3));

        boolean primBoolean2 = objBoolean2.booleanValue();
        System.out.println("primBoolean2 = " + primBoolean2);
    }
}
