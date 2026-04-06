package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejercicio_9;

import java.util.Objects;

public class Contacto {
    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Contacto persona = (Contacto) obj;
        return Objects.equals(this.telefono, persona.telefono);
    }

    @Override
    public int hashCode(){
        return Objects.hash(telefono);
    }

    @Override
    public String toString(){
        return String.format(
                "\n------------------------------------------\n%-15s : %s\n%-15s : %s\n%s",
                "Nombre", nombre,
                "Teléfono", telefono,
                "------------------------------------------"
        );
    }
}
