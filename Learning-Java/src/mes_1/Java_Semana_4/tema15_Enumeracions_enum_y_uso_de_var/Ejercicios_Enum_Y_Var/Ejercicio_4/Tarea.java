package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_4;

public class Tarea {
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;

    public Tarea(String titulo, String descripcion, Prioridad prioridad){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public Prioridad getPrioridad(){
        return prioridad;
    }

    @Override
    public String toString(){
        return String.format(
                "\n---------------------------------\n%-15s : %s\n%-15s : %s\n%-15s : %s %s\n%s",
                "- Titulo: ", titulo,
                "- Descripción: ", descripcion,
                "- Prioridad: ", prioridad.getPrioridad(), prioridad.getIcono(),
                "---------------------------------\n"
        );
    }

}
