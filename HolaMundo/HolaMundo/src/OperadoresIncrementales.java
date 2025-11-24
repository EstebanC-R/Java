public class OperadoresIncrementales {
    static void main(String[] args) {
        int i = 1;
        int k = ++i; // i = i + 1;

        // Pre - incremento
        System.out.println("i = " + i);
        System.out.println("k = " + k);
        
        // Post - incremento
        
        i = 2;
        System.out.println("Inicial de i = " + i);
        k = i++;
        System.out.println("i = " + i);
        System.out.println("k = " + k);

        // Pre - decremento
        i = 3;
        k = --i; // i = i - 1 = 2. por lo tanto k = 2 y la variable i disminuye en 1
        System.out.println("i = " + i);
        System.out.println("k = " + k);


        // Post - decremento
        i = 4;
        k = i--; // solo se le asigna el valor de i ya que despues se decrementa.
        System.out.println("i = " + i);
        System.out.println("k = " + k);

        System.out.println("(++k) = " + (++k));
        System.out.println("(++k) = " + (k++));
        System.out.println("k = " + k);

    }
}
