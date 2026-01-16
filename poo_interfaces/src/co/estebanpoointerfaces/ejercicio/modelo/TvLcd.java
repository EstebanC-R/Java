package co.estebanpoointerfaces.ejercicio.modelo;

public class TvLcd extends Electronico{

    int pulgada;

    public TvLcd(int precio, String fabricante, int pulgada) {
        super(precio, fabricante);
        this.pulgada = pulgada;
    }

    public int getPulgada() {
        return pulgada;
    }

    @Override
    public double getPrecioVenta() {
        return precio;
    }
}
