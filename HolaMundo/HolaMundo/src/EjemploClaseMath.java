public class EjemploClaseMath {
    static void main() {

        // ? entrega un valor absoluto
        int absuluto = Math.abs(-3);
        System.out.println("absuluto = " + absuluto);

        absuluto = Math.abs(3);
        System.out.println("absuluto = " + absuluto);

        // $ Para encontrar el maximo en 2 números.
        double max = Math.max(3.5, 1.3);
        System.out.println("max = " + max);
        
        
        double min = Math.min(3.5, 1.2);
        System.out.println("min = " + min);

        
        // ! Redondear al valor maximo redondeado, osea 1.5 pues 2 porque es el valor maximo a redondear.
        double techo = Math.ceil(3.5);
        System.out.println("techo = " + techo);

        // ! Lo mismo que el anterior pero en vez de hacía arriba es hacía abajo.
        double piso = Math.floor(3.5);
        System.out.println("piso = " + piso);

        // ! Simplemente para redondear dependiendo del decimal.
        long entero = Math.round(3.5);
        System.out.println("entero = " + entero);
        
        // ! Exponenciar con el valor de E = 2.718281828459045
        double exp = Math.exp(2);
        System.out.println("exp = " + exp);

        // ! Logaritmo natural (ln) 2.71828
        double log = Math.log(10);
        System.out.println("log = " + log);

        // ? La potenciación básicamente es 10 elevado al cubo.
        double potencia = Math.pow(10, 3);
        System.out.println("potencia = " + potencia);

        // ? La Raíz cuadrada de un número.
        double raiz = Math.sqrt(5);
        System.out.println("raiz = " + raiz);
        
        // ! Basicamente para ver los grados si se tiene los radianes.
        double grados = Math.toDegrees(1.57);
        grados = Math.round(grados);
        System.out.println("Convertir a grados = " + grados);

        
        double radianes = Math.toRadians(90.00);
        System.out.println("Convertir grados a radianes = " + radianes);

        // ! Seno, coseno de 90 requiere un double y radianes, en este caso se tomó el anterior llamado radianes.
        System.out.println("sin(90) = " + Math.sin(radianes));
        System.out.println("cos(90) = " + Math.cos(radianes));

    }
}
