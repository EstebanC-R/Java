package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.executors;

import java.util.concurrent.*;

public class ExecutorServiceCallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> calcularSuma = () -> {
            int suma = 0;
            suma += 10;
            return suma;
        };

        Future<Integer> future = executor.submit(calcularSuma);
        System.out.println("Iniciando el calculo ......");
        System.out.println("Calculando ....");
        TimeUnit.SECONDS.sleep(2);
        // ? Integer resultado = future.get(); Para guardar en una variable si se quiere
        System.out.println("El resultado es: " + future.get());

        executor.shutdown();
    }
}
