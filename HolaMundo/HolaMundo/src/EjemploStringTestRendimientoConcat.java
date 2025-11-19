public class EjemploStringTestRendimientoConcat {
    static void main() {
        String a = "a";
        String b = "b";
        String c = a;

        StringBuilder sb = new StringBuilder(a);
        long inicio = System.currentTimeMillis();

        for(var i = 0; i < 100000; i++){
            // c = c.concat(a).concat(b).concat("\n"); // 500 => 2ms, 1000 => 2ms, 10000 => 98ms, 100000 => 4257ms
            // c += a + b + "\n"; // 500 => 10ms, 1000 => 10ms, 10000 => 44ms, 100000 => 1625ms
            sb.append(a).append(b).append("\n"); // 500 => 0ms, 1000 => 0ms, 10000 => 2ms, 100000 => 7ms
        }

        long fin = System.currentTimeMillis();

        System.out.println(fin - inicio);
        System.out.println("c = " + c);
        System.out.println("sb.toString() = " + sb.toString());
    }
}
