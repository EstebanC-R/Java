package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos.sistematickets;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class EjercicioTickets {
    public static void main(String[] args) throws InterruptedException {

        SistemaTickets sistema = new SistemaTickets(100);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        AtomicInteger rechazados = new AtomicInteger(0);

        for(int i = 0; i < 150; i++){
            final int clienteId = i;
            executor.submit(() -> {
                boolean vendido = sistema.venderTicket("Cliente #" + clienteId);
                if(!vendido){
                    rechazados.incrementAndGet();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\nTickets restantes: " + sistema.getTicketsDisponibles());
        System.out.println("Tickets vendidos: " + sistema.getTicketsVendidos());
        System.out.println("Número de personas sin tickets: " + rechazados.get());
    }
}