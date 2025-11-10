package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_6;

public class Main {
    public static void main(String[] args) {
        Pedido p = new Pedido(2, "Motocicleta", EstadoPedido.PENDIENTE);
        System.out.println(p);

        p.cambiarEstado(EstadoPedido.PAGADO);
        System.out.println(p);

        p.cambiarEstado(EstadoPedido.ENVIADO);
        p.cancelarPedido();
        System.out.println(p);

    }
}
