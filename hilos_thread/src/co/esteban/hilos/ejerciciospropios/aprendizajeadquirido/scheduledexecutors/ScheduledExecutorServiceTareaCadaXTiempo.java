package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.scheduledexecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTareaCadaXTiempo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Tarea ejecutándose ...");
        }, 0, 2, TimeUnit.SECONDS);

        // $ Básicmante se ejecuta en el rango de 0 a 2 segundos hasta que se hace el Thread.sleep() y seguido el shutdown();
        Thread.sleep(10000);
        scheduler.shutdown();
        System.out.println("Finalizó las tareas.");
    }
}
