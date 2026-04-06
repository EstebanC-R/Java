package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_9;

import java.util.Objects;

public class Persona {
    private String id;
    protected String nombre;
    protected int edad;
    protected String email;


    public Persona(String id, String nombre, int edad, String email){
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Persona person = (Persona) obj;
        return Objects.equals(this.id, person.id);
    }


    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return String.format(
                "-----------------------------------\n%-15s : %s\n%-15s : %d\n%-15s : %s\n%-15s : %s\n%s",
                "Nombre", nombre,
                "Edad", edad,
                "Email", email,
                "ID", id,
                "-----------------------------------"
        );
    }
}
