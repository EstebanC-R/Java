package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.runnablethread;

public class Ejercicio1 {
    public static void main(String[] args) {

        Runnable tarea = () -> {
            for(int i = 0; i < 5; i++){
                System.out.println("Hola desde el " + Thread.currentThread().getName() + " #" + (i + 1));
            }
        };

        Thread hilo = new Thread(tarea, "Hilo-Aprendizaje");
        hilo.start();

        System.out.println("Hola desde el hilo " + Thread.currentThread().getName());
    }
}
