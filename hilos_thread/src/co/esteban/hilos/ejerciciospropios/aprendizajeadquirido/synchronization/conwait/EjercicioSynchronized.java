package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.synchronization.conwait;

public class EjercicioSynchronized {
    public static void main(String[] args) throws InterruptedException {

        ContadorSeguro contador = new ContadorSeguro();

        for(int i = 0; i < 100; i++){
            System.out.println("Estamos en el " + Thread.currentThread().getName() + "# " + (i + 1));
            new Thread(() -> {
                for(int j = 0; j < 10; j++){
                    contador.incrementar();
                }
            }, "Hilo").start();
        }

        Thread.sleep(2000);
        System.out.println("Valor final: " + contador.getValor());

        // % Aquí el contador usa synchronized.
        // % Eso asegura que solo un hilo a la vez pueda incrementar el valor.
        // % Gracias a la exclusión mutua, el resultado siempre será 1000.
        // % Los hilos siguen ejecutándose en paralelo, pero se turnan para entrar al método.
    }
}
