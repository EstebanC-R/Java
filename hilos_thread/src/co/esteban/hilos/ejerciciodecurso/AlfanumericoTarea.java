package co.esteban.hilos.ejerciciodecurso;

public class AlfanumericoTarea implements Runnable {

    private Tipo tipo;

    public AlfanumericoTarea(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public void run() {
        if(tipo == Tipo.NUMERO){
            for(int i = 1; i < 10; i++){
                System.out.println(i);
            }
        }

        if(tipo.equals(Tipo.LETRA)){
            for(char letra = 'A'; letra <= 'Z'; letra++){
                System.out.println(letra + " ");
            }
        }
    }


}
