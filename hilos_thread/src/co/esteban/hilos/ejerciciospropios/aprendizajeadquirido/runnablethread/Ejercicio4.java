package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.runnablethread;

public class Ejercicio4 {
    public static void main(String[] args) throws InterruptedException {
        Thread descargador = new Thread(() -> {
            System.out.println("Descargando Archivo...");
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e){
                System.out.println("Mensaje: " + e.getMessage());
                e.printStackTrace(System.out);
            }

            System.out.println("Descarga Completada!");
        });

        descargador.start();
        System.out.println("Esperando descarga...");
        descargador.join();
        System.out.println("Ahora puedes usar el archivo!!");

        // ? ¿Qué pasa si NO usas join()? : La respuesta es que se imprimen "Esperando descarga..."
        // ? también "Ahora puedes usar el archivo!!" y ademas despues se imprime los 2 mensajes
        // ? dentro del Thread
    }
}
