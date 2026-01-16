package co.esteban.ejerciciosherencia.ejercicio3;

import java.util.Date;

public class Perecedero extends NoPerecedero{
    private Date fechaCaducidad;

    public Perecedero(String nombre, double precio, int contenido, int calorias, Date fechaCaducidad) {
        super(nombre, precio, contenido, calorias);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- Fecha de caducidad: " + fechaCaducidad;
    }
}
