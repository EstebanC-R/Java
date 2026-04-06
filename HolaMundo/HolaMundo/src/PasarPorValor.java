public class PasarPorValor {
    static void main() {
        Integer i = 10;

        System.out.println("Iniciamos el método main con i = " + i);
        test(i);
        System.out.println("Finaliza el método main con el valor de i (se mantiene igual) = " + i);
    }

    public static void test(Integer i){
        System.out.println("Iniciamos el método test con i = " + i);
        i = 35;
        System.out.println("Finaliza el método test con i = " + i);
    }
}
