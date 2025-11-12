package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);

        // Mostrar cada dato del enum.
        for(DiaSemana dia : DiaSemana.values()){
            System.out.println(dia);
        }

        // Metodo para saber si es o no un día laboral
        diaSemana(rl);
        System.out.println();

        // Mostrar el número del día .ordinal()

        for(DiaSemana dia : DiaSemana.values()){
            System.out.println("- " + dia + " - " + (dia.ordinal() + 1));
        }


    }

    public static void diaSemana(Scanner rl){
        while(true){
            System.out.println("\n\nBienvenido al sistema detector semanal.");
            System.out.println("Ingrese el día que quiere saber si es o no laboral.");
            String repuesta = rl.nextLine().toUpperCase().trim();

            try{
                DiaSemana dia = DiaSemana.valueOf(repuesta);
                UtilidadDelEnum.esLaboral(dia);
            }catch(IllegalArgumentException e){
                System.out.println("Día inválido. Intente con: LUNES, MARTES, etc.");
            }

            System.out.println("Quiere conocer 1. otro día ó 2. salir? (Escoja un número): ");

            while(!rl.hasNextInt()){
                System.out.println("Por favor ingrese un número valido: ");
                rl.next();
            }

            int opcion = rl.nextInt();

            if(opcion == 1){
                System.out.println("OK");
                rl.nextLine();
            }else{
                System.out.println("Hasta luego... :)");
                rl.close();
                return;
            }
        }
    }
}
