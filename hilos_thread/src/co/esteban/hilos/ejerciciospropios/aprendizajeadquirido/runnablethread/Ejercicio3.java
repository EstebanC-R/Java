package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.runnablethread;

public class Ejercicio3 {
    public static void main(String[] args) {

        Thread contador = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.out.println("Segundo: " + (i + 1));
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("Mensaje: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }
        });

        contador.start();
    }
}
