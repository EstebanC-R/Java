package EJERCICIOS_MES_1.Semana02_Registro_de_Estudiantes;

import java.util.ArrayList;
import java.util.Scanner;

public class ClaseLanzadoraRegistroEstudiante {

    static ArrayList<RegistroDeEstudiantes> lista = new ArrayList<>();

    public static void main(String[] args){
        Scanner rl = new Scanner(System.in);
        menu(rl);
    }

    public static void menu(Scanner rl){
        System.out.println("""
                Escoja una opción
                    - 1. Registrar estudiante.
                    - 2. Mostrar estudiantes.
                    - 3. Salir.
                """);
        System.out.println("Seleccione una opción: ");
        if(rl.hasNextInt()){
            int respuesta = rl.nextInt();
            rl.nextLine();
            switch (respuesta){
                case 1:
                    System.out.println("Coloque aquí el nombre del estudiante: ");
                    String nombre = rl.nextLine();

                    System.out.println("Coloque el curso del estudiante: ");
                    String curso = rl.nextLine();

                    System.out.println("Coloque la edad del estudiante: ");
                    int edad = rl.nextInt();
                    rl.nextLine();

                    RegistroDeEstudiantes alumno = new RegistroDeEstudiantes(nombre, edad, curso);
                    lista.add(alumno);
                    System.out.println("Estudiante Registrado con éxito ...");
                    menu(rl);
                    break;
                case 2:
                    System.out.println("\n=================== Cargando estudiantes ===================");
                    for(RegistroDeEstudiantes estudiante : lista){
                        System.out.println(estudiante);
                    }
                    System.out.println();
                    menu(rl);
                    break;
                case 3:
                    System.out.println("Hasta la proxima :) :P (^_^)");
                    rl.close();
                    break;
                default:
                    System.out.println("Escoja una opción valida\n");
                    menu(rl);
            }
        }else{
            System.out.println("Escoja una opción valida, vuelva a intentarlo :) ");
            rl.next();
            menu(rl);
        }
    }
}
