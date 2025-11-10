package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_10;

public enum EstadoTicket {
    ABIERTO("Abierto", "🆕", true),
    EN_PROGRESO("En Progreso", "⌛", true),
    EN_REVISION("En Revisión", "👀", true),
    RESUELTO("Resuelto", "✅", false),
    CERRADO("Cerrado", "🔒", false);

    private String estado;
    private String iconoEstado;
    private boolean puedeAvanzar;

    EstadoTicket(String estado, String iconoEstado, boolean puedeAvanzar){
        this.estado = estado;
        this.iconoEstado = iconoEstado;
        this.puedeAvanzar = puedeAvanzar;
    }

    public String getEstado(){
        return estado;
    }

    public String getIconoEstado() {
        return iconoEstado;
    }

    public boolean puedeAvanzar() {
        return puedeAvanzar;
    }
}
