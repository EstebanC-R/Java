package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_6;

import java.util.Scanner;

public class Pedido {
    private int id;
    private String producto;
    private EstadoPedido estado;


    public Pedido(int id, String producto, EstadoPedido estado){
        this.id = id;
        this.producto = producto;
        this.estado = estado;
    }

    public void cambiarEstado(EstadoPedido nuevoEstado){
        if(this.estado.puedeAvanzar()){
            this.estado = nuevoEstado;
            System.out.println("\n✅ Se ha actualizado el estado a " + nuevoEstado.getDescripcion());
        }else{
            System.out.println("\n❌ El pedido esta en estado final " + estado.getDescripcion() + ". No se puede cambiar a " + nuevoEstado.getDescripcion());
        }
    }

    public String mostrarAvance(){
        return estado.puedeAvanzar() ? "✅ El pedido puede avanzar" : "❌ El pedido no puede avanzar";
    }

    public void cancelarPedido(){
        while(true){
            Scanner rl = new Scanner(System.in);
            System.out.println("Quieres cancelar el pedido? s/n");
            System.out.println("Respuesta: ");
            String seleccion = rl.nextLine().toLowerCase().trim();

            switch (seleccion) {
                case "s":
                    if (this.estado.puedeAvanzar()) {
                        EstadoPedido cancelarPedido = EstadoPedido.CANCELADO;
                        this.estado = cancelarPedido;

                        System.out.println("El pedido ha sido cancelado.");
                    } else {
                        System.out.println("No se puede cancelar ya que esta en un estado final " + estado.getDescripcion());
                    }
                    return;
                case "n":
                    System.out.println("Cancelando cambio de estado...");
                    rl.close();
                    return;
                default:
                    System.out.println("Se ha equivocado, vuelva a intentarlo: ");
            }
        }
    }

    @Override
    public String toString(){
        return String.format(
                "\n------------------------------------------\n%-15s : %d\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%s",
                "ID-Pedido", id,
                "Producto", producto,
                "Estado", estado,
                "Actualización", mostrarAvance(),
                "------------------------------------------"
        );
    }
}
