package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_4;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        menu(rl);
    }

    static ArrayList<Tarea> tareas = new ArrayList<>();

    public static void menu(Scanner rl){
        while(true){
            System.out.println("---- Sistema de Tareas ----");
            System.out.println("1. Agregar Tarea.");
            System.out.println("2. Ordenar por prioridad (Alto - Bajo)");
            System.out.println("3. Mostrar solo las tareas ALTA Y URGENTE");
            System.out.println("4. Salir.");
            System.out.println("Seleccione una opción: ");

            while(!rl.hasNextInt()){
                System.out.println("Seleccione un número valido (1 - 4): ");
                rl.next();
            }

            int seleccion = rl.nextInt();
            rl.nextLine();

            while(seleccion < 1 || seleccion > 4){
                System.out.println("Por favor seleccione una opción valida: ");

                while(!rl.hasNextInt()){
                    System.out.println("Seleccione un número valido (1 - 4): ");
                    rl.next();
                }

                seleccion = rl.nextInt();
                rl.nextLine();
            }

            switch (seleccion){
                case 1:
                    System.out.println("\n---------------- Agregar Tarea ----------------");
                    System.out.println("- Titulo: ");
                    String titulo = rl.nextLine();

                    System.out.println("- Descripción: ");
                    String descripcion = rl.nextLine();

                    System.out.println("- Seleccione la prioridad: ");

                    int i = 1;

                    for(Prioridad p : Prioridad.values()){
                        System.out.println(i + ". - " + p.getPrioridad() + " " + p.getIcono());
                        i++;
                    }
                    System.out.println("Selección: ");

                    int prioridad = rl.nextInt();
                    rl.nextLine();

                    if(prioridad >= 1 && prioridad <= Prioridad.values().length){
                        Prioridad prioridadSeleccionada = Prioridad.values()[prioridad - 1];
                        Tarea t = new Tarea(titulo, descripcion, prioridadSeleccionada);
                        tareas.add(t);
                        System.out.println(t);
                    }else{
                        System.out.println("Error, selecciona un dato valido.");
                    }
                    break;
                case 2:
                    System.out.println("\n---- Ordenar por Prioridad (Alto → Bajo) ----");

                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                        break;
                    }

                    // Ordenamos usando Comparator
                    tareas.sort((t1, t2) ->
                            Integer.compare(
                                    t2.getPrioridad().getNivelDeRiesgo(),
                                    t1.getPrioridad().getNivelDeRiesgo()
                            )
                    );

                    System.out.println("\n--- Tareas ordenadas por prioridad ---");
                    for (Tarea t : tareas) {
                        System.out.println(t);
                    }
                    break;
                case 3:
                    System.out.println("\n------- Mostrar Tareas URGENTES y ALTAS -------");

                    for (Tarea t : tareas) {
                        Prioridad p = t.getPrioridad(); // obtenemos el enum

                        if (p == Prioridad.URGENTE || p == Prioridad.ALTA) {
                            System.out.println(t);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Hasta la próxima :) :P (^_^) ");
                    rl.close();
                    return;
            }

        }
    }
}
