package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceFixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 10; i++){
            int numeroTarea = i;
            executor.submit(() -> {
                System.out.println("Tarea " + (numeroTarea + 1) + ": " + Thread.currentThread().getName());
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Tarea " + (numeroTarea + 1) + " ha terminado!!");
            });
        }

        executor.shutdown();
        System.out.println("Inicio de tareas ...");
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Todas las tareas han terminado :)");

        // % Claro, al permitir 3 hilos a la vez este no asegura el orden en el que se cumplan
        // % por ello ninguna espera a ninguna y se hacen en paralelo.
    }
}
