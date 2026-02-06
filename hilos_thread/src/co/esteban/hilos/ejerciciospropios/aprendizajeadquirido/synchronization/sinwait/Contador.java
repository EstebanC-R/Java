package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.synchronization.sinwait;

public class Contador {
    private int valor = 0;


    public void incrementar(){
        valor++;
    }

    public int getValor(){
        return valor;
    }
}
