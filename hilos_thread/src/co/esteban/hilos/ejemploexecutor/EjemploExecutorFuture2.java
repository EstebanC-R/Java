package co.esteban.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        // ! Ejecuta según su número de tareas, es decir que si pones 2,
        // ! primero va a priorizar 2 y por ultimo la ultima, básicamente es
        // ! por tandas newFixedThreadPool(n).
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executor.getQueue().size());

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

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3 ...");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main 1");

        // # System.out.println("La tarea finalizó: " + resultado.isDone());
        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone()? "finalizó" : "en proceso ...",
                    resultado2.isDone()? "finalizó" : "en proceso ...",
                    resultado3.isDone()? "finalizó" : "en proceso ..."));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        //System.out.println("Resultado de la tarea: " + resultado.get(5, TimeUnit.SECONDS));
        System.out.println("Resultado de la tarea 1: " + resultado.get());
        System.out.println("¿La tarea 1 finalizó?: " + resultado.isDone());

        System.out.println("Resultado de la tarea 2: " + resultado2.get());
        System.out.println("¿La tarea 2 finalizó?: " + resultado2.isDone());

        System.out.println("Resultado de la tarea 3: " + resultado.get());
        System.out.println("¿La tarea 3 finalizó?: " + resultado3.isDone());

    }
}
