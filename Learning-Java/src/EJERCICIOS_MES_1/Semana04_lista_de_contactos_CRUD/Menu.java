package EJERCICIOS_MES_1.Semana04_lista_de_contactos_CRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static ArrayList<Contacto> contactos = new ArrayList<>();
    public static void menu(Scanner rl){
        while (true){
            System.out.println("-------------- Lista de contactos. --------------");
            System.out.println("1. Agregar contacto.");
            System.out.println("2. Ver lista de contactos.");
            System.out.println("3. Actualizar contacto.");
            System.out.println("4. Eliminar contacto.");
            System.out.println("5. Buscar Contacto.");
            System.out.println("6. Salir.");
            var respuesta = respuestaMenu(rl, 1, 6);
            rl.nextLine();
            switch (respuesta){
                case 1:
                    System.out.println("--------- Creando Contacto ---------");
                    System.out.println("Nombre de contacto: ");
                    var nombre = rl.nextLine();

                    System.out.println("Número de contacto: ");
                    var numero = validaNumero(rl);

                    System.out.println("Seleccione la Categoría: ");

                    var contador = 1;
                    for(EstadoDeContacto c : EstadoDeContacto.values()){
                        System.out.println(contador + " - " + c + " " + c.getIcono());
                        contador++;
                    }

                    var seleccion = respuestaMenu(rl, 1, 5);
                    rl.nextLine();

                    var cont = new Contacto(nombre, numero, EstadoDeContacto.values()[seleccion - 1]);
                    contactos.add(cont);
                    System.out.println("\n- Contacto creado con éxito.\n");
                    break;
                case 2:
                    verContactos();
                    break;
                case 3:
                    actualizarContacto(rl);
                    break;
                case 4:
                    eliminarContacto(rl);
                    break;
                case 5:
                    buscarContacto(rl);
                    break;
                case 6:
                    System.out.println("Hasta la próxima.");
                    return;
            }
        }
    }

    public static int respuestaMenu(Scanner rl, int datoMin, int datoMax){
        System.out.println("- Respuesta: ");

        var seleccion = validaNumero(rl);

        while(seleccion < datoMin || seleccion > datoMax){
            System.out.println("Su respuesta debe estar entre las opciones " + datoMin + " y " + datoMax + ": ");

            seleccion = validaNumero(rl);
            rl.nextLine();
        }

        return seleccion;
    }

    public static int validaNumero(Scanner rl){
        while (!rl.hasNextInt()){
            System.out.println("Su respuesta debe ser un dato númerico.");
            rl.next();
        }

        return rl.nextInt();
    }

    public static void verContactos(){
        listaEstaVacia();

        for(Contacto c : contactos){
            System.out.println(c);
        }
    }

    public static void actualizarContacto(Scanner rl){
        listaEstaVacia();

        System.out.println("\n--- Actualizar Contacto ---");
        System.out.println("Selecciona el #ID del contacto: ");
        verContactos();

        var id = respuestaMenu(rl, 1, contactos.size());

        for(Contacto cont : contactos){
            if(cont.getID() == id){
                System.out.println("Qué quieres actualizar?");
                System.out.println("1. Nombre.");
                System.out.println("2. Número.");
                System.out.println("3. Categoría.");
                System.out.println("4. Salir.");

                var respuesta = respuestaMenu(rl, 1, 4);
                rl.nextLine();

                switch (respuesta){
                    case 1:
                        int cancelar = cancelar(rl);
                        if(cancelar == 2){
                            return;
                        }else{
                            rl.nextLine();
                            System.out.println("Nombre actual: " + cont.getNombre());
                            System.out.println("Nombre nuevo: ");
                            var nuevoNombre = rl.nextLine();
                            cont.setNombre(nuevoNombre);
                            System.out.println("\nCambio guardado.\n");
                            System.out.println(cont);
                            break;
                        }
                    case 2:
                        int cancelar1 = cancelar(rl);
                        if(cancelar1 == 2){
                            return;
                        }else{
                            System.out.println("Número actual: " + cont.getNumero());
                            System.out.println("Número nuevo: ");
                            var numeroNuevo = validaNumero(rl);
                            cont.setNumero(numeroNuevo);
                            System.out.println(cont);
                            break;
                        }
                    case 3:
                        cancelar(rl);
                        System.out.println("Actual categoría: " + cont.getCategoria());
                        System.out.println("Nueva categoría: ");
                        int contador = 1;
                        for(EstadoDeContacto c : EstadoDeContacto.values()){
                            System.out.println(contador + " - " + c + " " + c.getIcono());
                            contador++;
                        }

                        var seleccion = respuestaMenu(rl, 1, 5);
                        rl.nextLine();
                        cont.setCategoria(EstadoDeContacto.values()[seleccion - 1]);
                        break;
                    case 4:
                        System.out.println("Ok");
                        break;
                }
            }
        }
    }

    public static int cancelar(Scanner rl){
        System.out.println("Estas seguro?");
        System.out.println("1. si");
        System.out.println("2. no");
        var respuesta = respuestaMenu(rl, 1, 2);

        return respuesta;
    }

    public static void eliminarContacto(Scanner rl){
        listaEstaVacia();

        System.out.println("Cual contacto quieres eliminar?");
        verContactos();
        var id = respuestaMenu(rl, 1, contactos.size());
        cancelar(rl);

        for(Contacto c : contactos){
            if(c.getID() == id){
                contactos.remove(c);
                System.out.println("Se ha eliminado correctamente.");
                return;
            }
        }
    }

    public static void listaEstaVacia(){
        if(contactos.isEmpty()){
            System.out.println("Aún no tienes contactos.");
            return;
        }

        System.out.println("...");
    }

    public static void buscarContacto(Scanner rl){
        listaEstaVacia();

        System.out.println("Ingresa el nombre: ");
        var nombre = rl.nextLine();
        boolean encontrado = false;

        for(Contacto c : contactos){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Resultado: ");
                System.out.println(c);
                encontrado = true;
                return;
            }
        }

        if(!encontrado){
            System.out.println("\nNo ha encontrado el contacto\n");
        }
    }
}
