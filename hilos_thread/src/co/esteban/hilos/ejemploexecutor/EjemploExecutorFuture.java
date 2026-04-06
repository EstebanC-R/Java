package co.esteban.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {


        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("inicio de la tarea...");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace(System.out);
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea ...");
            return "Algún resultado importante de la tarea.";
        };

        Future<String> resultado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main 1");

        // # System.out.println("La tarea finalizó: " + resultado.isDone());
        while (!resultado.isDone()){
            System.out.println("Ejecutando tarea ....");
            TimeUnit.MILLISECONDS.sleep(1500);
        }

        //System.out.println("Resultado de la tarea: " + resultado.get(5, TimeUnit.SECONDS));
        System.out.println("Resultado de la tarea: " + resultado.get());
        System.out.println("¿La tarea finalizó?: " + resultado.isDone());

        // % Se probó con ambos, tanto Runnable como con Callable<T> la diferencia entre ambos
        // % es que Runnable no devuelve nada mientras que Callable<T> devuelve algo del tipo T
    }
}
