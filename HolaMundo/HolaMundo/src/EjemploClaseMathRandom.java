import java.util.Random;

public class EjemploClaseMathRandom {
    static void main() {
        String[] colores = {"Azul", "Amarillo", "Verde", "Naranja", "Rojo", "Morado"};

        // * Toma un número random del 0 al 0.9999999
        double random = Math.random();
        System.out.println("Número random = " + random);
        random *= colores.length;

        System.out.println("Número random multiplicado por 7 = " + random);

        random = Math.floor(random);
        System.out.println("random redondeado = " + random);

        System.out.println("Color random = " + colores[(int)random]);

        Random randomObj = new Random();
        int randomInt = randomObj.nextInt(); // * Sin valor el nextInt() retorna un número entero con un rango amplio, puede ser negativo o positivo
        // * Si le pones un valor por ejemplo 7 este lo que hace es que básicamente lo toma de 0 a 7 sin incluir 7 osea 6.99999.
        System.out.println("randomInt = " + randomInt);

        int randomInt2 = randomObj.nextInt(7);
        System.out.println("randomInt2 = " + randomInt2);

        // $ De esta forma lo que pasa es que básicamente le das un rango entre 15 y 25, porque lo que haces es 25 -15 = 10
        // $ Pero en realidad es [0, 9.9999] lo que sucede al poner el 15 del principio es correr ese rango haciendo que [15, 24.9999].
        int randomIntConRangoEspecifico = 15 + randomObj.nextInt(25 - 15);
        System.out.println("randomIntConRangoEspecifico = " + randomIntConRangoEspecifico);

        randomInt = randomObj.nextInt(colores.length);
        System.out.println("Num Random con clase Random para lista Colores = " + randomInt);
        System.out.println("Colores = " + colores[randomInt]);
    }
}
