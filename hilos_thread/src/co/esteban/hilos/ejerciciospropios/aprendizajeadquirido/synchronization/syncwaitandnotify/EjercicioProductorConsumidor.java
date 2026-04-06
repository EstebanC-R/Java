package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.synchronization.syncwaitandnotify;

public class EjercicioProductorConsumidor {
    public static void main(String[] args) {

        Almacen almacen = new Almacen();

        // % Productor

        new Thread(() -> {
            for(int i = 1; i <= 5; i++){
                almacen.producir("Producto-" + i);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("Mensaje: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }
        }).start();

        // # Consumidor
        new Thread(() -> {
            for(int i = 1; i <= 5; i++){
                almacen.consumir();
            }
        }).start();
    }
}
