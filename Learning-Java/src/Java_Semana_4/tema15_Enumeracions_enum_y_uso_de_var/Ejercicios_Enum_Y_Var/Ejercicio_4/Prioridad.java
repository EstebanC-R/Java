package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_4;

public enum Prioridad {
    BAJA("Baja", 1, "💚"),
    MEDIA("Media", 2, "💛"),
    ALTA("Alta", 3, "❤️"),
    URGENTE("Urgente", 4, "🚨");

    private String prioridad;
    private int nivelDeRiesgo;
    private String icono;

    Prioridad(String prioridad, int nivelDeRiesgo, String icono){
        this.prioridad = prioridad;
        this.nivelDeRiesgo = nivelDeRiesgo;
        this.icono = icono;
    }

    public String getPrioridad(){
        return prioridad;
    }

    public String getIcono(){
        return icono;
    }

    public int getNivelDeRiesgo(){
        return nivelDeRiesgo;
    }

}
