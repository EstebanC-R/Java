package co.esteban.anotaciones.ejemplo.models;

import co.esteban.anotaciones.ejemplo.Init;
import co.esteban.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {

    @JsonAtributo
    private String nombre;

    @JsonAtributo(nombre = "costo")
    private long precio;

    private LocalDate fecha;

    @Init
    private void init(){
        this.nombre = Arrays.stream(nombre.split(" "))
                .map(palabra -> palabra.substring(0, 1)
                        .toUpperCase() + palabra
                        .substring(1)
                        .toLowerCase()).collect(Collectors.joining(" "));
    }


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
