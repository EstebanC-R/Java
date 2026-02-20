package co.esteban.ejemplos.EjercicioList;

public enum Destino {
    SANTIAGO("Santiago");

    private String destino;

    Destino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return destino;
    }
}
