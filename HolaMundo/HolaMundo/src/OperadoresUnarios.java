public class OperadoresUnarios {
    static void main(String[] args) {
        int i = -5;

        int k = +i; // k = (1)*i => -5;
        System.out.println("k = " + k);

        int p = -i; // p = (-1)*i => 5;
        System.out.println("p = " + p);

        i = 6;
        k = +i;
        System.out.println("k = " + k);
        
        p = -i;
        System.out.println("p = " + p);
    }
}
