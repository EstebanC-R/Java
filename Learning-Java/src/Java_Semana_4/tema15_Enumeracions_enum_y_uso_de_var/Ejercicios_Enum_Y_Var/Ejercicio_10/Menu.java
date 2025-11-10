package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu(Scanner rl, ArrayList<Ticket> listaTickets){
        boolean ciclo = false;
        while(!ciclo){
            System.out.println("\n\n------------ Bienvenido al sistema de Respuesta de Tickets ------------\n");
            System.out.println("1. Crear Ticket. ");
            System.out.println("2. Ver todos los Tickets.");
            System.out.println("3. Filtrar por estado. ");
            System.out.println("4. Filtrar por prioridad. ");
            System.out.println("5. Cambiar estado de ticket. ");
            System.out.println("6. Agregar comentario a ticket. ");
            System.out.println("7. Cerrar Ticket. ");
            System.out.println("8. Ver estadísticas. (Estado y Prioridad)");
            System.out.println("9. Salir");
            System.out.println("Selección: ");


            while(!rl.hasNextInt()){
                System.out.println("Por favor seleccione en formato número: ");
                rl.next();
            }

            int seleccion = rl.nextInt();

            if(seleccion < 1 || seleccion > 9){
                System.out.println("Por favor, seleccione la opcioón dentro del rango propuesto (1 - 9): ");

                while(!rl.hasNextInt()){
                    System.out.println("Recuerde que el tipo de respuesta debe ser númerica del 1 al 9: ");
                    rl.next();
                }

                seleccion = rl.nextInt();
                rl.nextLine();
            }

            switch (seleccion){
                case 1:
                    rl.nextLine();
                    crearTicket(rl, listaTickets);
                    break;
                case 2:
                    verTodoLostickets(listaTickets);
                    break;
                case 3:
                    filtrarPorEstado(rl, listaTickets);
                    break;
                case 4:
                    filtrarPorPrioridad(rl, listaTickets);
                    break;
                case 5:
                    cambiarEstadoDeTicket(rl, listaTickets);
                    break;
                case 6:
                    rl.nextLine();
                    for(Ticket ticket : listaTickets){
                        ticket.agregarComentarioSegunId(rl, listaTickets);
                    }
                    break;
                case 7:
                    cerrarTicket(rl, listaTickets);
                    break;
                case 8:
                    estadisticas(listaTickets);
                    break;
                case 9:
                    System.out.println("Hasta luego.");
                    ciclo = true;
                    break;
            }
        }
        rl.close();
    }

    public static void crearTicket(Scanner rl, ArrayList<Ticket> listaTickets){
        System.out.println("- Asunto de tu PQRS: ");
        String title = rl.nextLine();

        System.out.println("- Explica el motivo de tú consulta: ");
        String descripcion = rl.nextLine();

        System.out.println("\n- En que proceso va tu ticket?: \n");

        int contador = 1;
        for(EstadoTicket tick : EstadoTicket.values()){
            System.out.println(contador + " - " + tick);
            contador++;
        }
        System.out.println("\nRespuesta: ");

        while(!rl.hasNextInt()){
            System.out.println("Por favor escoge el número en que va el proceso de tú ticket: ");
            rl.next();
        }

        int proceso = rl.nextInt();

        while(proceso < 1 || proceso > 5){

            System.out.println("Por favor escoge un número dentro del rango (1- 5): ");

            while(!rl.hasNextInt()){
                System.out.println("Por favor escoge el número en que va el proceso de tú ticket: ");
                rl.next();
            }

            proceso= rl.nextInt();
            rl.nextLine();
        }

        System.out.println("- La prioridad del ticket es: \n");

        contador = 1;

        for(PrioridadTicket prio : PrioridadTicket.values()){
            System.out.println(contador + " - " + prio);
            contador++;
        }

        System.out.println("\nRespuesta: ");

        while(!rl.hasNextInt()){
            System.out.println("Por favor escoge el número de prioridad de tú ticket: ");
            rl.next();
        }

        int prio = rl.nextInt();

        while(prio < 1 || prio > 4){
            System.out.println("Por favor escoge un número dentro del rango (1- 4): ");

            while(!rl.hasNextInt()){
                System.out.println("Por favor escoge el número de prioridad de tú ticket: ");
                rl.next();
            }

            prio= rl.nextInt();
            rl.nextLine();
        }

        System.out.println("- Cual es la categoría de tu ticket?: \n");

        contador = 1;
        for(CategoriaTicket cat : CategoriaTicket.values()){
            System.out.println(contador + " - " + cat);
            contador++;
        }

        System.out.println("\nRespuesta: ");

        while(!rl.hasNextInt()){
            System.out.println("Por favor escoge el número de Categoría de tú ticket: ");
            rl.next();
        }

        int cat = rl.nextInt();

        while(cat < 1 || cat > 4){
            System.out.println("Por favor escoge un número dentro del rango (1- 4): ");

            while(!rl.hasNextInt()){
                System.out.println("Por favor escoge el número de Categoría de tú ticket: ");
                rl.next();
            }

            cat = rl.nextInt();
            rl.nextLine();
        }
        rl.nextLine();
        System.out.println("- Por favor coloque su nombre: ");
        String nombre = rl.nextLine();

        System.out.println("Deseas agregar algún otro comentarío que se deba tener en cuenta para la solución de tu duda? (s/n): ");
        String comen = rl.nextLine();

        var ticket = new Ticket(title, descripcion, EstadoTicket.values()[proceso - 1], PrioridadTicket.values()[prio - 1], CategoriaTicket.values()[cat - 1], nombre);

        switch (comen.toLowerCase()){
            case "s":
                ticket.agregarComentario(rl);
                System.out.println(ticket);
                listaTickets.add(ticket);
                break;
            case "n":
                System.out.println(ticket);
                listaTickets.add(ticket);
                break;
            default:
                System.out.println("Creo que te confundiste escoge una respuesta valida: ");
                break;
        }


    }

    public static void verTodoLostickets(ArrayList<Ticket> listaTicket){
        if(listaTicket.isEmpty()){
            System.out.println("\n--------------------------------------------------");
            System.out.println("\nEn este momento no hay ningún ticket a soluciónar.\n");
            System.out.println("--------------------------------------------------\n");
        }else{
            for(var tick : listaTicket){
                System.out.println(tick);
            }
        }
    }

    public static void filtrarPorEstado(Scanner rl, ArrayList<Ticket> listaTicket){

        System.out.println("Cual estado quieres filtrar: \n");

        var contador = 1;
        for(EstadoTicket es : EstadoTicket.values()){
            System.out.println(contador+" - "+es);
            contador++;
        }

        System.out.println("Respuesta: ");

        while (!rl.hasNextInt()) {
            System.out.println("Por favor escoge un número del 1 al " + EstadoTicket.values().length);
            rl.next();
        }

        int seleccion = rl.nextInt();

        if(seleccion < 1 || seleccion > EstadoTicket.values().length){
            System.out.println("Por favor escoge un número dentro del rango del 1 al " + EstadoTicket.values().length + ":");

            while (!rl.hasNextInt()){
                System.out.println("Que sea por supuesto un número: ");
                rl.next();
            }

            seleccion = rl.nextInt();
            rl.nextLine();
        }

        boolean encontrado = false;

        for(Ticket ti : listaTicket){
            if(ti.getEstado() == EstadoTicket.values()[seleccion - 1]){
                System.out.println(ti);
                encontrado = true;
            }
        }

        if(!encontrado){
            System.out.println("\n---------------------------------------------");
            System.out.println("No se han encontrado datos con este filtro.");
            System.out.println("---------------------------------------------\n");
        }
    }

    public static void filtrarPorPrioridad(Scanner rl, ArrayList<Ticket> listaTicket){
        System.out.println("Por cual prioridad quieres filtrar?: \n");

        var contador = 1;
        for(var tick : PrioridadTicket.values()){
            System.out.println(contador + " - " + tick);
            contador++;
        }

        while(!rl.hasNextInt()){
            System.out.println("Por favor escoge un número: ");
            rl.next();
        }

        int seleccion = rl.nextInt();

        while(seleccion < 1 || seleccion > PrioridadTicket.values().length){
            System.out.println("Escoge la tú respuesta del 1 al " + PrioridadTicket.values().length);

            while(!rl.hasNextInt()){
                System.out.println("Que séa un dato del tipo número: ");
                rl.next();
            }
            seleccion = rl.nextInt();
            rl.nextLine();
        }

        boolean encontrado = false;

        for(var tick : listaTicket){
            if(tick.getPrioridad() == PrioridadTicket.values()[seleccion - 1]){
                System.out.println(tick);
                encontrado = true;
            }
        }

        if(!encontrado){
            System.out.println("\n---------------------------------------------");
            System.out.println("No se han encontrado datos con este filtro.");
            System.out.println("---------------------------------------------\n");
        }
    }

    public static void cambiarEstadoDeTicket(Scanner rl, ArrayList<Ticket> listaTicket){

        System.out.println("Cual es el número ID del Ticket al cual le quieres cambiar el estado: ");

        for(var tick : listaTicket){
            System.out.println(tick);
        }

        System.out.println("Respuesta: ");

        while(!rl.hasNextInt()){
            System.out.println("\nPor favor escoge un ID valido: ");
            rl.next();
        }

        int seleccion = rl.nextInt();

        while(seleccion < 1 || seleccion > listaTicket.size()){
            System.out.println("Por favor selecciona un número valido: ");

            while(!rl.hasNextInt()){
                System.out.println("Que sea valido por favor: ");
                rl.next();
            }

            seleccion = rl.nextInt();
            rl.nextLine();
        }

        boolean cambiado = false;
        var contador = 1;

        for(var tick : listaTicket){
            if(tick.getId() == seleccion){
                System.out.println(tick);
                System.out.println();

                for(EstadoTicket est : EstadoTicket.values()){
                    System.out.println(contador + " - " + est);
                    contador++;
                }

                System.out.println("Selecciona el cambio de estado: ");

                while(!rl.hasNextInt()){
                    System.out.println("Selecciona el número de opción del estado: ");
                    rl.next();
                }

                int nuevoEstado = rl.nextInt();

                while(nuevoEstado < 1 || nuevoEstado > EstadoTicket.values().length){
                    System.out.println("Por favor selecciona dentro del rango dado del 1 al " + EstadoTicket.values().length);

                    while(!rl.hasNextInt()){
                        System.out.println("Por favor selecciona un dato dentro del rango: ");
                        rl.next();
                    }

                    nuevoEstado = rl.nextInt();
                    rl.nextLine();
                }

                tick.cambiarEstado(EstadoTicket.values()[nuevoEstado - 1]);

                System.out.println(tick);
                cambiado = true;
            }
        }

        if(!cambiado){
            System.out.println("No se pudo cambiar el estado.");
        }

    }

    public static void cerrarTicket(Scanner rl, ArrayList<Ticket> listaTicket){
        System.out.println("Quieres cerrar un ticket?\n1. si \n2. volver\nRespuesta: ");

        while(!rl.hasNextInt()){
            System.out.println("Por favor escoge un número valido.");
            break;
        }

        int respuesta = rl.nextInt();

        switch (respuesta){
            case 1:
                if(listaTicket.isEmpty()){
                    System.out.println("La lista esta vacía.");
                    return;
                }

                System.out.println("Por favor escoge el número de ID-Ticket a cerrar: ");

                for(Ticket ti : listaTicket){
                    System.out.println(ti);
                }

                System.out.println("Número a escoger del Ticket: ");
                int numero = rl.nextInt();

                boolean encontrado = false;

                for(Ticket ti : listaTicket){
                    if(numero == ti.getId()){
                        if(ti.getEstado() == EstadoTicket.RESUELTO){
                            System.out.println("\n✅ Se puede cerrar el ticket.");
                            ti.setEstado(EstadoTicket.CERRADO);
                            System.out.println(ti);
                            encontrado = true;
                        }else{
                            System.out.println("\n❌ No se puede cerrar hasta que este resuelto el ticket.");
                            return;
                        }
                    }
                }

                if(!encontrado){
                    System.out.println("No se ha encontrado este ticket.");
                    return;
                }

                break;
            case 2:
                System.out.println("Volviendo... ... ");
                break;
            default:
                System.out.println("Escoge una opción valida: ");
                rl.next();
                break;
        }
    }

    public static void estadisticas(ArrayList<Ticket> listaTicket){
        if(listaTicket.isEmpty()){
            System.out.println("No hay datos para filtrar estadísticas. ");
            return;
        }

        int abiertos = 0;
        int enProgreso = 0;
        int enRevision = 0;
        int resueltos = 0;
        int cerrados = 0;

        for(Ticket ti : listaTicket){
            switch (ti.getEstado()){
                case ABIERTO -> abiertos++;
                case EN_PROGRESO -> enProgreso++;
                case EN_REVISION -> enRevision++;
                case RESUELTO -> resueltos++;
                case CERRADO -> cerrados++;
            }
        }

        System.out.println("- Abiertos: " + abiertos);
        System.out.println("- En Progreso: " + enProgreso);
        System.out.println("- En Revisión: " + enRevision);
        System.out.println("- Resueltos: " + resueltos);
        System.out.println("- Cerrados: "+ cerrados);
    }

}
