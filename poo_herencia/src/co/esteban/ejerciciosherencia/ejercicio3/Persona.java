package co.esteban.ejerciciosherencia.ejercicio3;

public class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private String numeroDeIdentificacion;

    public Persona(String nombre, String apellido, String direccion, String numeroDeIdentificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.numeroDeIdentificacion = numeroDeIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumeroDeIdentificacion() {
        return numeroDeIdentificacion;
    }

    @Override
    public String toString() {
        return "\n- Nombre: " + nombre +
                "\n- Apellido: " + apellido +
                "\n- Dirección: " + direccion +
                "\n- Número de identificación: " + numeroDeIdentificacion;
    }
}
