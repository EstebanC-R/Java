package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos.sistematickets;

import java.util.concurrent.atomic.AtomicInteger;

public class SistemaTickets {
    private AtomicInteger ticketsDisponibles;
    private AtomicInteger ticketsVendidos;

    public SistemaTickets(int tickets){
        this.ticketsDisponibles = new AtomicInteger(tickets);
        this.ticketsVendidos = new AtomicInteger(0);
    }

    public boolean venderTicket(String cliente){
        if(ticketsDisponibles.get() > 0){
            int numeroTicket = ticketsDisponibles.getAndDecrement();
            ticketsVendidos.incrementAndGet();
            System.out.println("El cliente " + cliente + " compró el ticket #" + numeroTicket);
            return true;
        } else {
            System.out.println(cliente + " - se han agotado los tickets. :(");
            return false;
        }
    }

    public int getTicketsDisponibles(){
        return ticketsDisponibles.get();
    }

    public int getTicketsVendidos(){
        return ticketsVendidos.get();
    }
}