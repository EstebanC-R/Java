package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_10;

import java.util.ArrayList;
import java.util.Scanner;


public class Ticket {
    public static int contador = 1;

    private int id = contador;
    private String titulo;
    private String descripcion;
    private EstadoTicket estado;
    private PrioridadTicket prioridad;
    private CategoriaTicket categoria;
    private String creadoPor;
    private ArrayList<String> comentarios;

    public Ticket(String titulo, String descripcion, EstadoTicket estado, PrioridadTicket prioridad, CategoriaTicket categoria, String creadoPor){
        this.id = contador++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.categoria = categoria;
        this.creadoPor = creadoPor;
        this.comentarios = new ArrayList<>();
    }

    public void agregarComentario(Scanner rl){
        System.out.println("Cual es tú comentario: ");
        String comentario = rl.nextLine();

        comentarios.add(comentario);

        System.out.println("\nSe ha agregado tu comentario exitosamente. ");
    }

    public void agregarComentarioSegunId(Scanner rl, ArrayList<Ticket> listaTickets){
        if(listaTickets.isEmpty()){
            System.out.println("No hay tickets disponibles.");
            return;
        }

        System.out.println("Tickets disponibles:");
        for(Ticket tick : listaTickets){
            System.out.println("ID: " + tick.getId() + " - " + tick);
        }

        System.out.println("Ingresa el ID del ticket: ");
        int id = rl.nextInt();
        rl.nextLine();

        for(Ticket ti : listaTickets){
            if(ti.getId() == id){
                ti.agregarComentario(rl);
                return;
            }
        }

        System.out.println("❌ No se encontró un ticket con ese ID");
    }

    public String formatearComentarios() {
        if (comentarios.isEmpty()) {
            return "         (Sin comentarios)";
        }

        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (String c : comentarios) {
            sb.append("\n 💬 " + i + ". " + c + "\n");
            i++;
        }
        return sb.toString();
    }

    public void cambiarEstado(EstadoTicket nuevoEstado){
        if(this.estado == EstadoTicket.CERRADO){
            System.out.println("❌ No se puede modificar un ticket cerrado");
            return;
        }

        if (this.estado.puedeAvanzar()){
            this.estado = nuevoEstado;
            System.out.println("✅ Se ha actualizado el estado a " + nuevoEstado.getEstado());
        }else {
            System.out.println("❌ El estado ya esta en la etapa final " + estado.getEstado());
        }
    }

    @Override
    public String toString(){
        return String.format(
                "\n-------------------------------------\n%-15s : %d\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%s\n%23s \n%s\n",
                "- ID-Card", id,
                "- Titulo", titulo,
                "- Descripción", descripcion,
                "- Estado", estado,
                "- Prioridad", prioridad,
                "- Categoria", categoria,
                "- Creado por", creadoPor,
                "--------------------------------------",
                "Comentarios", formatearComentarios(),
                "-------------------------------------\n"
        );
    }


    public EstadoTicket getEstado(){
        return estado;
    }

    public void setEstado(EstadoTicket estado){
        this.estado = estado;
    }

    public PrioridadTicket getPrioridad(){
        return prioridad;
    }

    public int getId(){
        return id;
    }

    public ArrayList<String> getComentarios(){
        return comentarios;
    }
}
