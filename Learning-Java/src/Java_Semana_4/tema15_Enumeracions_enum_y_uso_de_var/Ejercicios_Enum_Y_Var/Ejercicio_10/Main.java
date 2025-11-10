package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var rl = new Scanner(System.in);
        ArrayList<Ticket> listaTickets = new ArrayList<>();
        Menu.menu(rl, listaTickets);
        Menu.crearTicket(rl, listaTickets);
        Menu.filtrarPorEstado(rl, listaTickets);
    }
}
