package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceNewSingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        /*ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea1 = () -> {
            for(int i = 1; i <= 5; i++){
                System.out.println("☠️ Primer Tarea " + Thread.currentThread().getName() + " " + i);
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e){
                    System.out.println("Mensaje: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }
        };

        Runnable tarea2 = () -> {
            for(int i = 1; i <= 5; i++){
                System.out.println("🐐 Segunda Tarea " + Thread.currentThread().getName() + " " + i);
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e){
                    System.out.println("Mensaje: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }
        };

        Runnable tarea3 = () -> {
            for(int i = 1; i <= 5; i++){
                System.out.println("😾 Primer Tarea " + Thread.currentThread().getName() + " " + i);
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e){
                    System.out.println("Mensaje: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }
        };


        executor.submit(tarea1);

        executor.submit(tarea2);

        executor.submit(tarea3);

        executor.shutdown();
        System.out.println("Inicio de Tareas ....");
        executor.awaitTermination(16, TimeUnit.SECONDS);
        System.out.println("Las tareas han terminado :)");*/

        // % ----------------------------------------------------------------------------------------

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 5; i++) {
            int tareaNum = i;
            executor.submit(() -> {
                System.out.println("Tarea " + tareaNum + " ejecutándose en " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("Mensaje: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            });
        }

        executor.shutdown();
        System.out.println("Inicio de Tareas.....");
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Las tareas, se han completado!!");


        // Este programa usa un ExecutorService con un solo hilo.
        // Se envían 5 tareas que se ejecutan en orden, una por una.
        // Cada tarea imprime su número y simula trabajo con sleep.
        // Al final se espera a que todas terminen antes de cerrar.
    }
}
