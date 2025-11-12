package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejercicio_4;

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args){
        Scanner rl = new Scanner(System.in);
        Lista list = new Lista();
        menu(rl, list);
    }

    static void menu(Scanner rl, Lista list){

        System.out.println("\n------------------- Bienvenido al sistemas To Work -------------------");
        System.out.println("\nSelecciona una opción basado en lo que quieres hacer: ");
        System.out.println("\n1. Agregar nota." +
                "\n2. Mostrar todas las tareas." +
                "\n3. Eliminar tarea." +
                "\n4. Marcar tarea como completada." +
                "\n5. Mostrar tareas completadas." +
                "\n6. Contar tareas pendientes." +
                "\n7. Salir");
        System.out.println("Respuesta (Selecciona un número 1 - 7) : ");

        while(!rl.hasNextInt()){
            System.out.println("\nPor favor seleccione una opción valida: ");
            rl.next();
        }

        int respuesta = rl.nextInt();
        rl.nextLine(); // limpiar entrada

        switch (respuesta){
            case 1:
                System.out.println("Introduzca la tarea que quiere agregar: ");
                String tarea = rl.nextLine();
                list.agregarTarea(tarea);
                System.out.println("\nTarea agregada con éxito.");
                menu(rl, list);
                break;
            case 2:
                list.mostrarTareas();
                menu(rl, list);
                break;
            case 3:
                list.mostrarTareas();

                if (list.tareas.isEmpty()) {
                    System.out.println("\nNo hay tareas para eliminar. Digite 00 para volver al menú.");
                } else {
                    System.out.println("\n¿Qué tarea quieres eliminar? (o digita 00 para volver)");
                }

                String input = rl.nextLine();

                // Si escribe 00 → volver
                if (input.equals("00")) {
                    menu(rl, list);
                    break;
                }

                int tareaAEliminar;
                try {
                    tareaAEliminar = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                    menu(rl, list);
                    break;
                }

                list.eliminarTarea(tareaAEliminar);
                menu(rl, list);
                break;
            case 4:
                list.mostrarTareas();
                System.out.println("\n¿Qué tarea quiere marcar como completa?\nPor favor seleccione el número correspondiente: ");
                int tareaCompletada = Integer.parseInt(rl.nextLine());
                System.out.println("Tarea marcada con éxito.");
                list.completarTarea(tareaCompletada);
                menu(rl, list);
                break;
            case 5:
                list.mostrarTareasCompletadas();
                menu(rl, list);
                break;
            case 6:
                list.mostrarTareasPendientes();
                menu(rl, list);
                break;
            case 7:
                System.out.println("Gracias por utilizar nuestro servicio.\n\nHasta la próxima :) :P :v (^_^)");
                rl.close();
                break;
            default:
                System.out.println("Por favor escoja una opción dentro del rango: ");
                rl.nextLine();
                menu(rl,list);
        }

    }
}
