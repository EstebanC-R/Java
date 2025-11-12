package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejercicio_9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Menu {
    public static void menu(Scanner sc, ArrayList<Contacto> contactos, HashSet<String> telefonos){



        System.out.println("\n-------------------- Menú de Contactos --------------------");
        System.out.println("1. Agregar Contacto.");
        System.out.println("2. Buscar contacto por nombre.");
        System.out.println("3. Mostrar todos los contactos.");
        System.out.println("4. Eliminar contacto.");
        System.out.println("5. Cantidad de Contactos.");
        System.out.println("6. Salir.");
        System.out.println("Seleccione una opción 1-6: ");



        while(!sc.hasNextInt()){
            System.out.println("Por favor ingrese un valor valido: ");
            sc.next();
        }

        int opcion = Integer.parseInt(sc.nextLine());

        while(opcion < 1 || opcion > 6){
            System.out.println("Por favor ingrese un número dentro del rango antes mencionado: ");
            sc.next();
        }

        switch (opcion){
            case 1:
                System.out.println("\n---------- Agregar Contacto ---------");
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Teléfono: ");
                String telefono = sc.nextLine();

                if (telefonos.contains(telefono)) {
                    System.out.println("- Ese teléfono ya está registrado.");
                } else {
                    Contacto contacto = new Contacto(nombre, telefono);
                    contactos.add(contacto);
                    telefonos.add(telefono);
                    System.out.println("- Contacto agregado éxitosamente");
                }

                menu(sc, contactos, telefonos);
                break;
            case 2:
                System.out.println("\n------- Buscar Contacto por Nombre -------");
                System.out.println("Buscador: ");
                nombre = sc.nextLine();
                boolean encontrado = false;

                for(Contacto c : contactos){
                    if(c.getNombre().equalsIgnoreCase(nombre)){
                        System.out.println("Contacto encontrado: " + c);
                        encontrado = true;
                        break;
                    }
                }

                if(!encontrado){
                    System.out.println("Contacto no encontrado :(");
                }

                menu(sc, contactos, telefonos);
                break;
            case 3:
                System.out.println("\n---- Lista de Contactos ----");

                for(Contacto c : contactos){
                    System.out.println(c);
                }
                menu(sc, contactos, telefonos);
                break;
            case 4:
                System.out.println("\n---- Eliminar Contacto ----");
                System.out.println("Nombre: ");
                nombre = sc.nextLine();

                boolean encontrarParaEliminar = false;

                for(Contacto c : contactos){
                    if(c.getNombre().equalsIgnoreCase(nombre)){
                        contactos.remove(c);
                        telefonos.remove(c.getTelefono());
                        encontrarParaEliminar = true;
                        System.out.println("Eliminado éxitosamente");
                        break;
                    }
                }

                if(!encontrarParaEliminar){
                    System.out.println("No se encontró un contacto con este nombre.");
                }

                menu(sc, contactos, telefonos);
                break;
            case 5:
                System.out.println("\n---- Cantidad de Contactos ----");
                System.out.println(contactos.size());
                menu(sc, contactos, telefonos);
                break;
            case 6:
                System.out.println("\n------------------- Salir -------------------");
                System.out.println("\nGracias por utilizar nuestro servicio :) :3 :P (^_^)");
                sc.close();
                break;
            default:
                System.out.println("Creo que te confundiste en tú elección, por favor vuelve a intentarlo: ");
                sc.next();
                break;
        }
    }
}
