package co.esteba.pruebas.nivel2.models;

import java.time.LocalDate;

public class Cliente {
    private Integer id;
    private String nombre;
    private String email;
    private LocalDate fechaRegistro;

    public Cliente(Integer id, String nombre, String email, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "\n- ID: " + id +
                "\n- Nombre: " + nombre +
                "\n- Email: " + email +
                "\n- Fecha de registro: " + fechaRegistro;
    }
}
