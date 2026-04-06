package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.synchronization.syncwaitandnotify;

public class Almacen {
    private String producto = null;
    private boolean disponible = false;

    public synchronized void producir(String nuevoProducto){

        while(disponible){
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("Mensaje: " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }

        this.producto = nuevoProducto;
        System.out.println("⬇️ Producido: " + producto);
        this.disponible = true;

        notify();
    }


    public synchronized String consumir(){

        while (!disponible){
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("Mensaje: " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }

        System.out.println("✅ Consumido: " + this.producto);
        this.disponible = false;

        notify();

        return producto;
    }
}
