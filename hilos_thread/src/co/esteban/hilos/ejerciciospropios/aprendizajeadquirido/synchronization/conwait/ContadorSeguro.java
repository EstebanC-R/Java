package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.synchronization.conwait;

public class ContadorSeguro {
    private int valor = 0;

    public synchronized void incrementar(){
        valor++;
    }

    public synchronized int getValor(){
        return this.valor;
    }
}
