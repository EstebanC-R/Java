package Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejercicio_4;

import java.util.ArrayList;


public class Lista {
    ArrayList<String> tareas;
    ArrayList<String> pendientes;
    ArrayList<String> completadas;

    public Lista(){
        tareas = new ArrayList<>();
        pendientes = new ArrayList<>();
        completadas = new ArrayList<>();
    }

    public void agregarTarea(String tarea){
        tareas.add(tarea);
    }

    public void mostrarTareas(){
        int contador = 1;

        if(tareas.isEmpty()){
            System.out.println("No hay tareas para ver.");
        }

        for(String ta : tareas){
            System.out.println(contador + ". " + ta);
            contador++;
        }
    }

    public void eliminarTarea(int seleccion){
        if (seleccion < 1 || seleccion > tareas.size()) {
            System.out.println("Número inválido. ");
            return;
        }

        tareas.remove(seleccion - 1);
        System.out.println("\nTarea eliminada con éxito. :)");
    }


    public void completarTarea(int seleccion){
        seleccion = seleccion - 1;
        String tareaOriginal = tareas.get(seleccion);
        String tareaCompletada = "✅ " + tareaOriginal;

        tareas.set(seleccion, tareaCompletada);
        completadas.add(tareaCompletada);

        mostrarTareas();
    }

    public void mostrarTareasCompletadas(){
        System.out.println("\n------------------- Tareas Completadas ----------------");
        int contador = 1;

        if(completadas.isEmpty()){
            System.out.println("No hay tareas completadas.");
        }
        for(String com : completadas){
            System.out.println(contador + ". " + com);
            contador++;
        }
    }

    public void mostrarTareasPendientes(){
        pendientes.clear();

        for(String ta : tareas){
            if(!ta.startsWith("✅")){
                pendientes.add(ta);
            }
        }

        if(pendientes.isEmpty()){
            System.out.println("No hay tareas pendientes.");
            return;
        }

        System.out.println("\n------------------- Tareas Pendientes ----------------\n");
        int contador = 1;
        for(String pend : pendientes){
            System.out.println(contador + ". " + pend);
            contador++;
        }
    }

}
