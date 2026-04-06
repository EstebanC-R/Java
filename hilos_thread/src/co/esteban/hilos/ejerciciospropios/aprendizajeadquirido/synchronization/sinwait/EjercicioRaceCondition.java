package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.synchronization.sinwait;

public class EjercicioRaceCondition {
    public static void main(String[] args) throws InterruptedException {

        Contador contador = new Contador();

        Runnable tarea = () -> {
            for(int i = 0; i < 10; i++){
                System.out.println("Estamos en el " + Thread.currentThread().getName());
                contador.incrementar();
            }
        };

        for (int i = 0; i < 12000; i++) {
            Thread hilo = new Thread(tarea, "hilo-" + (i + 1));
            hilo.start();
        }


        Thread.sleep(5000);
        System.out.println("Valor final: " + contador.getValor());
        System.out.println("Valor esperado: 120000");

        // ? En este ejercicio el contador no está protegido.
        // ? Como varios hilos incrementan al mismo tiempo, algunos incrementos se pueden perder.
        // ? El resultado esperado es 1000, pero en la práctica puede ser menor.
        // ? Esto se llama "condición de carrera" porque el resultado depende de cómo se intercalan los hilos.

    }
}
