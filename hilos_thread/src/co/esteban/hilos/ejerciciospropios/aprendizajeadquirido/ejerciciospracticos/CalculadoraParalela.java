package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos;

import java.util.concurrent.*;

public class CalculadoraParalela {
    static long sumarRango(int inicio, int fin){
        long suma = 0;
        for(int i = inicio; i <= fin; i++){
            suma += i;
        }
        return suma;
    }

    public static void main(String[] args) throws Exception {
        Callable<Long> parte1 = () -> sumarRango(1, 250000);
        Callable<Long> parte2 = () -> sumarRango(250001, 500000);
        Callable<Long> parte3 = () -> sumarRango(500001, 750000);
        Callable<Long> parte4 = () -> sumarRango(750001, 1000000);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<Long> resultado1 = executor.submit(parte1);
        Future<Long> resultado2 = executor.submit(parte2);
        Future<Long> resultado3 = executor.submit(parte3);
        Future<Long> resultado4 = executor.submit(parte4);

        Long[] resultados = {resultado1.get(), resultado2.get(), resultado3.get(), resultado4.get()};

        long sumaTotal = 0;
        int count = 0;
        for(long r : resultados){
            sumaTotal += r;
        }

        executor.shutdown();
        System.out.println("Iniciando Calculo ...");

        while(count < 5){
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Calculando ...");
            count++;
        }
        System.out.println("El resulta total es: " + sumaTotal);
    }
}
