package co.esteban.ejerciciosherencia.ejercicio3;

public class Vendedor extends Persona{
    private String numeroCarnet;

    public Vendedor(String nombre, String apellido, String direccion, String numeroDeIdentificacion, String numeroCarnet) {
        super(nombre, apellido, direccion, numeroDeIdentificacion);
        this.numeroCarnet = numeroCarnet;
    }

    public String getNumeroCarnet() {
        return numeroCarnet;
    }

    @Override
    public String toString() {
        return "\n======= Datos Vendedor =======" + super.toString() +
                "\n- Número de carnet: " + numeroCarnet;
    }
}
