package co.esteban.ejemplos.EjercicioList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Vuelo implements Comparable<Vuelo> {
    private String nombre;
    private Origen origen;
    private Destino destino;
    private Date fechaLlegadaYHora;
    private int cantidadPasajeros;

    public Vuelo(String nombre, Origen origen, Destino destino, Date fechaLlegadaYHora, int cantidadPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLlegadaYHora = fechaLlegadaYHora;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Date getFechaLlegadaYHora() {
        return fechaLlegadaYHora;
    }

    public void setFechaLlegadaYHora(Date fechaLlegadaYHora) {
        this.fechaLlegadaYHora = fechaLlegadaYHora;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public static Date fixFechaHora(String fechaString){
        SimpleDateFormat sf = new SimpleDateFormat("EEE dd MMM yyyy HH:mm 'hrs'", new Locale("es", "ES"));
        try{
            Date fecha = sf.parse(fechaString);
            return fecha;
        } catch (ParseException e){
            System.out.println("Mensaje: " + e.getMessage());
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("%-6s %-18s | %-18s | %-18s | %-18s | %12s %5s",
                "|", nombre, origen.getCiudad(), destino.getDestino(), fechaLlegadaYHora, cantidadPasajeros, "|"
        );
    }

    @Override
    public int compareTo(Vuelo o) {
        if(this.getCantidadPasajeros() == o.getCantidadPasajeros()){
            return 0;
        }
        if(this.getCantidadPasajeros() > o.cantidadPasajeros){
            return 1;
        }else {
            return -1;
        }
    }
}
