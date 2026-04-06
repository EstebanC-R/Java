package co.esteban.hilos.ejemplos.runnable;

// ! La implementación de Runnable no permite heredar de otra clase que no sea Thread
// ! por lo tanto no nos obliga a la implementación de un thread
public class ViajeTarea implements Runnable{
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println(i + " - " + nombre);
            try{
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e){
                System.out.println("Mensaje: " + e.getMessage());
                e.printStackTrace(System.out);
            }
        }

        System.out.println("Finalmente me voy de viaje a " + nombre);
    }
}
