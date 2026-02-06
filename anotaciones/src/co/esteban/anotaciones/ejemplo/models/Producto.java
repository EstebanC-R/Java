package co.esteban.anotaciones.ejemplo.models;

import co.esteban.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;

public class Producto {

    @JsonAtributo
    private String nombre;

    @JsonAtributo(nombre = "costo")
    private long precio;

    private LocalDate fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
