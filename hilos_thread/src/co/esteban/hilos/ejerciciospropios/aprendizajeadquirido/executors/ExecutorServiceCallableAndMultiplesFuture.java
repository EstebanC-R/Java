package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.executors;

import java.util.concurrent.*;

public class ExecutorServiceCallableAndMultiplesFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> suma1 = () -> {
            int suma = 0;
            for(int i = 1; i <= 100; i++){
                suma += i;
            }
            return suma;
        };

        Callable<Integer> suma2 = () -> {
            int suma = 0;
            for(int i = 101; i <= 200; i++){
                suma += i;
            }
            return suma;
        };

        Callable<Integer> suma3 = () -> {
            int suma = 0;
            for(int i = 201; i <= 300; i++){
                suma += i;
            }
            return suma;
        };

        Future<Integer> resultado1 = executor.submit(suma1);
        Future<Integer> resultado2 = executor.submit(suma2);
        Future<Integer> resultado3 = executor.submit(suma3);

        System.out.println("\nsuma1 = " + resultado1.get());
        System.out.println("suma2 = " + resultado2.get());
        System.out.println("suma3 = " + resultado3.get());

        System.out.println("\n- El resultado total de las 3 sumas es = " + (resultado1.get() + resultado2.get() + resultado3.get()));

        executor.shutdown();
    }
}
