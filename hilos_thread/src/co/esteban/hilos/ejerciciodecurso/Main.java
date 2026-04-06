package co.esteban.hilos.ejerciciodecurso;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        AlfanumericoTarea tarea1Num = new AlfanumericoTarea(Tipo.NUMERO);
        AlfanumericoTarea tarea2Let = new AlfanumericoTarea(Tipo.LETRA);


        Thread execute1 = new Thread(tarea1Num);
        Thread execute2 = new Thread(tarea2Let);

        execute1.start();
        execute2.start();
        execute1.join();
        System.out.println();
        execute2.join();
    }
}
