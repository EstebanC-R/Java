package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.scheduledexecutors;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {
    public static void main(String[] args) throws InterruptedException {

        // ! TODO 1: Crear el ScheduledExecutorService con un solo hilo
        java.util.concurrent.ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        System.out.println("Inicio: " + new Date());

        scheduler.schedule(() -> {
            System.out.println("Tarea ejecutada en: " + new Date());
        }, 3, TimeUnit.SECONDS);

        Thread.sleep(5000);
        scheduler.shutdown();
        System.out.println("Tarea finalizada en: " + new Date());
    }
}