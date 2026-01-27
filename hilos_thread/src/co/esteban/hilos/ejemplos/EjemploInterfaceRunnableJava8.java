package co.esteban.hilos.ejemplos;

import co.esteban.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException{

        // $ Implementación de lambda
        Thread main = Thread.currentThread();
        Runnable viaje = () -> {
            for(int i = 0; i < 10; i++){
                System.out.println(i + " - " + Thread.currentThread().getName());
                try{
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e){
                    System.out.println("Mensaje: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName());
            System.out.println(main.getState());
        };

        Thread v1 = new Thread(viaje, "Isla de Pascua");
        Thread v2 = new Thread(viaje, "Robinson Crusoe");
        Thread v3 = new Thread(viaje, "Juan Fernandez");
        Thread v4 = new Thread(viaje, "Isla de Chiloe");

        // * Cada uno se llama la instancia con el método start(), ademas del join
        // * este ultimo para hacer que cada uno termine efectivamente y hacer que continue el main
        // * normal y sin que aparezca a medias de los start().

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join();

        // ! El sleep se ejecuta sobre el hilo en cuestion o actual, donde se este ejecutando, este ademas es
        // ! un método estatico.

        // ? El join se ejucta en la instancia del Thread, no es estatico.

        // # Thread.sleep(10000);
        System.out.println("\nContinuando con la ejecución del método main: " + main.getName());

    }
}
