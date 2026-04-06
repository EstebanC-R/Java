package co.esteban.hilos.ejemploexecutor;

import co.esteban.hilos.ejemplosync.Panaderia;
import co.esteban.hilos.ejemplosync.runnable.Consumidor;
import co.esteban.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executor.getQueue().size());

        Panaderia p  = new Panaderia();

        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);


        Future<?> future1 = executor.submit(productor);
        Future<?> future2 = executor.submit(consumidor);


        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executor.getQueue().size());

        executor.shutdown();



    }
}
