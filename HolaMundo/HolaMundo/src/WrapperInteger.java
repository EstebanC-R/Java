public class WrapperInteger {
    static void main() {
        int intPrimmitivo = 32768;
        Integer intObjeto = Integer.valueOf(intPrimmitivo); // Forma explicíta de crear un objeto del tipo Integer
        Integer intObjeto2 = 32545; // Lo mismo que la anterior solo que básicamente es directamente
        System.out.println("intObjeto = " + intObjeto);
        
        int num = intObjeto; // Esta es una forma implicita de convertir un Integer a su primmitivo int.
        System.out.println("num = " + num);
        int num2 = intObjeto.intValue(); // Este de hecho es el mismo que el anterior solo que basicamente el anterior lo hace de una forma que es por "debajo", pero es exactamente lo mismo
        System.out.println("num2 = " + num2);

        String valorTvLcd = "670000";
        Integer valor = Integer.valueOf(valorTvLcd); // De esta forma se convierte de un texto a un integer
        System.out.println("valor = " + valor);

        Short shortObjeto = intObjeto.shortValue(); // Aunque sea el maximo con short sea 32767, si se puede de esta forma,
        // Lo que ocurre es que se pierde información. Dando valores totalmente ambiguos y negativos, mientras este fuera del rango del short
        System.out.println("shortObjeto = " + shortObjeto);

        Byte byteObjeto = intObjeto.byteValue(); // Al igual que el anterior se pierde toda la información siendo totalmente ambiguo ya que su max-value es 127
        System.out.println("byteObjeto = " + byteObjeto);

        Long longObjeto = intObjeto.longValue();
        System.out.println("longObjeto = " + longObjeto);


    }
}
