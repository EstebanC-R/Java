package co.esteba.pruebas.nivel1.models;

import co.esteba.pruebas.nivel1.exceptions.EdadInvalidaException;

public abstract class Persona {
    protected String nombre;
    protected int edad;
    protected int id;

    public Persona() {
    }

    public Persona(int id) {
        this.id = id;
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad < 18 || edad > 65){
            throw new EdadInvalidaException("La edad debe estar entre 18 y 65 años.");
        }
        this.edad = edad;

    }

    public int getId() {
        return id;
    }


    public abstract String obtenerRol();

    @Override
    public String toString() {
        return  "\n- ID: " + id +
                "\n- Nombre: " + nombre +
                "\n- Edad: " + edad +
                "\n- Tipo de rol: " + obtenerRol();
    }
}
