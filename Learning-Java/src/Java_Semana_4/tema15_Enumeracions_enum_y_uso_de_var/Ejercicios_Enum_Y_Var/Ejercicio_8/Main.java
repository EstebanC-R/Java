package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        while(true){
            System.out.println("\n\nCual es tú nombre?: ");
            String nombre = rl.nextLine();

            for(NivelUsuario niv : NivelUsuario.values()){
                System.out.printf("%d - Acceso : %-15s\n", (niv.getNivel() + 1), niv.getNombre());
            }

            System.out.println("Por favor selecciona tú nivel de acceso: ");

            while(!rl.hasNextInt()){
                System.out.println("Selecciona un nivel (1 - 4): ");
                rl.nextLine();
            }

            int nivel = rl.nextInt();

            while(nivel < 1 || nivel > 4){
                System.out.println("Por favor seleccione un rango valido (1 - 4): ");

                while (!rl.hasNextInt()){
                    System.out.println("Seleccione en base a lo antes dicho: ");
                    rl.nextLine();
                }

                nivel = rl.nextInt();
                rl.nextLine();
            }

            if(nivel == 1){
                NivelUsuario niv1 = NivelUsuario.INVITADO;
                Usuario user = new Usuario(nombre, niv1);
                menu(rl, niv1);
            }else if(nivel == 2){
                NivelUsuario niv2 = NivelUsuario.USUARIO;
                Usuario user = new Usuario(nombre, niv2);
                menu(rl, niv2);
            }else if(nivel == 3){
                NivelUsuario niv3 = NivelUsuario.MODERADOR;
                Usuario user = new Usuario(nombre, niv3);
                menu(rl, niv3);
            } else if (nivel == 4) {
                NivelUsuario niv4 = NivelUsuario.ADMINISTRADOR;
                Usuario user = new Usuario(nombre, niv4);
                menu(rl, niv4);
            }
            rl.close();
            return;
        }
    }

    public static void menu(Scanner rl, NivelUsuario nivel){
        while(true){
            System.out.println("Que quieres hacer?");
            System.out.println("1. Leer.");
            System.out.println("2. Editar.");
            System.out.println("3. Eliminar.");
            System.out.println("Respuesta: ");

            while(!rl.hasNextInt()){
                System.out.println("Selecciona un nivel (1 - 4): ");
                rl.nextLine();
            }

            int respuesta = rl.nextInt();
            String accion;

            while(respuesta < 1 || respuesta > 3){
                System.out.println("Por favor seleccione un rango valido (1 - 3): ");

                while (!rl.hasNextInt()){
                    System.out.println("Seleccione en base a lo antes dicho: ");
                    rl.nextLine();
                }

                respuesta = rl.nextInt();
                rl.nextLine();
            }

            if(respuesta == 1){
                accion = "leer";
                nivel.tienePermiso(accion);
            }else if(respuesta == 2){
                accion = "editar";
                nivel.tienePermiso(accion);
            }else if(respuesta == 3){
                accion = "Eliminar";
                nivel.tienePermiso(accion);
            }
            rl.close();
            return;
        }
    }
}
