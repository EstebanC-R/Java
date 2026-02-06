package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.runnablethread;

public class Ejercicio2 {
    public static void main(String[] args) {

        Runnable tarea = () -> {
            for(int i = 0; i < 5; i++){
                System.out.println("Hola desde el " + Thread.currentThread().getName());
            }
        };

        Thread hilo1 = new Thread(tarea, "Hilo-A");
        Thread hilo2 = new Thread(tarea, "Hilo-B");
        Thread hilo3 = new Thread(tarea, "Hilo-C");

        hilo1.start();
        hilo2.start();
        hilo3.start();

        // % Todos se mezclan debido a que se ejecutan en paralelo y esto hace
        // % que no sea efectivo su orden, puede empezar el hilo B y terminar el C
        // % u otro orden.
    }


}
