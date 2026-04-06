package co.esteban.ejerciciosherencia.ejercicio1;

public class Empleado extends Persona {
    private double remuneracion;
    private int empleadoId;
    private static int contador = 1;

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion){
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = contador++;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void aumentarRemuneracion(int porcentaje){
        this.remuneracion = this.remuneracion * (1 + (porcentaje / 100.0));
    }

    @Override
    public String toString() {
        return super.toString() + "\n- Remuneración: " + remuneracion +
                "\n- Empleado ID: " + empleadoId;
    }
}
