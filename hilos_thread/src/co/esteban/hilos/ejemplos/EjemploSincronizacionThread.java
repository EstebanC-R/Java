package co.esteban.hilos.ejemplos;

import co.esteban.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirFrases("Hola ", "que tal!")).start();
        new Thread(new ImprimirFrases("¿Quién eres ", "tú?")).start();
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias amigo!"));
        h3.start();
        Thread.sleep(100);
        System.out.println(h3.getState());
    }

    // ! Al poner synchronized este bloquea los siguientes para dejar que primero termine
    // ! el que se esta ejecutando.
    public synchronized static void imprimirFrases(String frase1, String frase2){
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(frase2);
    }
}
