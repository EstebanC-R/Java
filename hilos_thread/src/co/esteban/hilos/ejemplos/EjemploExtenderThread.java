package co.esteban.hilos.ejemplos;

import co.esteban.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Jhon Doe");
        hilo.start(); // # ---> internamente invoca y llama al run
        // $ Thread.sleep(2);

        Thread hilo2 = new NombreThread("Pepe");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Mailo");
        hilo3.start();
        System.out.println(hilo.getState());
    }
}
