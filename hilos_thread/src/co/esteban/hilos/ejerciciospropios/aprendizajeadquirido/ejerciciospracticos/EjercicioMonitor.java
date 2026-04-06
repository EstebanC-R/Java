package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EjercicioMonitor {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 10; i++){
            final int taskNum = i;
            executor.submit(() -> {
                System.out.println("Ejecutando tarea " + taskNum);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            System.out.println("\n--- Estado del Executor ---");
            System.out.println("Hilos activos: " + executor.getPoolSize());
            System.out.println("Tareas en cola: " + executor.getQueue().size());
            System.out.println("Hilos trabajando: " + executor.getActiveCount());
            System.out.println("Tareas completadas: " + executor.getCompletedTaskCount());

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("\nTodas las tareas han terminado.");

    }
}
