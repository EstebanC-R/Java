package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_1;

public class StockInsuficienteException extends Exception{
    private final String producto;
    private final int solicitado;
    private final int disponible;

    public StockInsuficienteException(String producto, int solicitado, int disponible){
        super("No hay suficiente stock de " + producto + ". Solicitado: " + solicitado + ", Disponible: " + disponible);
        this.producto = producto;
        this.solicitado = solicitado;
        this.disponible = disponible;
    }

    public int getFaltante() {
        return solicitado - disponible;
    }
}
