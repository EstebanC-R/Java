package co.esteban.ejerciciosherencia.ejercicio1;

public class Cliente extends Persona{
    private int clienteId;
    private static int contador = 1;

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = contador++;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return super.toString() + "\n- Cliente ID: " + clienteId;
    }
}
