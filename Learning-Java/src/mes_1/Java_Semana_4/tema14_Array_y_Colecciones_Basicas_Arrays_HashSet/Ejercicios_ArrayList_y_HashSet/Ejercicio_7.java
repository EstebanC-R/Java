package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio_7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashSet<String> estudiantes = new HashSet<>();
        menu(sc, estudiantes);
    }

    public static void menu(Scanner sc, HashSet<String> estudiantes){
        System.out.println("\n\n---- Bienvenido al sistema de registro de estudiantes ----");
        System.out.println("Escoge una de las siguientes opciones: ");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Verificar si un estudiante está registrado");
        System.out.println("3. Mostrar todos los estudiantes registrados");
        System.out.println("4. Cantidad de estudiantes");
        System.out.println("5. Dar de baja un estudiante");
        System.out.println("6. Salir");
        System.out.println("Escoja una opción: ");

        int opcion =  Integer.parseInt(sc.nextLine());

        switch (opcion){
            case 1:
                System.out.println("\n---- Registro de estudiantes ----");
                System.out.println("Introduzca el código del estudiante: ");
                String estudiante = sc.nextLine();

                if(estudiantes.add(estudiante)){
                    System.out.println("\nAgregado con éxito.");
                }else{
                    System.out.println("\nError: ese código ya está registrado.");
                }

                menu(sc, estudiantes);
                break;
            case 2:
                System.out.println("\n--- Verificar estudiante ---");
                System.out.println("Indique el código del estudiante que quiere investigar: ");
                String codigo = sc.nextLine();
                System.out.println("El estudiante se encuentra registrado?: " + estudiantes.contains(codigo));
                menu(sc, estudiantes);
                break;
            case 3:
                System.out.println("\n---- Mostrar Estudiantes ----");
                System.out.println(estudiantes);
                menu(sc, estudiantes);
                break;
            case 4:
                System.out.println("\n---- Cantidad de estudiantes ----");
                System.out.println("El número de estudiantes es de: " + estudiantes.size());
                menu(sc, estudiantes);
                break;
            case 5:
                System.out.println("\n---- Eliminar estudiante del sistema ----");
                System.out.println("Introduzca el código del estudiante: ");
                codigo = sc.nextLine();
                System.out.println("El estudiante " + estudiantes.remove(codigo) + ". Ha sido eliminado.");
                menu(sc, estudiantes);
                break;
            case 6:
                System.out.println("Gracias por utilizar nuestro sistema :) :P :3 (^_^)");
                sc.close();
                break;
            default:
                System.out.println("Por favor introduzca un número valido 1-6: ");
                sc.next();
                break;
        }
    }
}
