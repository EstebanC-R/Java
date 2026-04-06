package co.esteban.ejerciciosherencia.ejercicio3;

public class Cliente extends Persona{
    private static int contadorId = 1;
    private int clienteId;

    public Cliente(String nombre, String apellido, String direccion, String numeroDeIdentificacion) {
        super(nombre, apellido, direccion, numeroDeIdentificacion);
        this.clienteId = contadorId++;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return "\n======= Datos Cliente =======" + super.toString() +
                "\n- ID - Cliente: " + clienteId;
    }
}
