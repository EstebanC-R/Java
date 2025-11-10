package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_6;

public enum EstadoPedido {
    PENDIENTE("Pendiente de pago", false),
    PAGADO("Pagado", false),
    PROCESANDO("En proceso", false),
    ENVIADO("Enviado", false),
    ENTREGADO("Entregado", true),
    CANCELADO("Cancelado", true);

    private String descripcion;
    private boolean finalizado;

    EstadoPedido(String descripcion, boolean finalizado){
        this.descripcion = descripcion;
        this.finalizado = finalizado;
    }

    public boolean puedeAvanzar(){
        return !finalizado;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
