package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_10;

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

    public void agregarComentarioSegunId(Scanner rl, Ticket ticket, ArrayList<Ticket> listaTickets){
        if(listaTickets.isEmpty()){
            System.out.println("No hay datos en lista para poder cambiar.");
        }else {
            System.out.println("Ingresa el ID al que quieras agregar un comentario: ");

            for(Ticket tick : listaTickets){
                System.out.println(tick);
            }

            System.out.println("Respuesta: ");

            while(!rl.hasNextInt()){
                System.out.println("Por favor coloqué un número de ID valido: ");
                rl.next();
            }

            int id = rl.nextInt();

            while(id < 1 || id > listaTickets.size()){
                System.out.println("Selecciona un número dentro del rango valido de IDs: ");

                while(!rl.hasNextInt()){
                    System.out.println("Por favor coloqué un número de ID valido: ");
                    rl.next();
                }

                id = rl.nextInt();
                rl.next();
            }

            if(ticket.getId() == id){
                rl.nextLine();
                ticket.agregarComentario(rl);
            }
        }
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
