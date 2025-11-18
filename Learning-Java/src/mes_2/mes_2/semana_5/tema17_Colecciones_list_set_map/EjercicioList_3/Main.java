package mes_2.semana_5.tema17_Colecciones_list_set_map.EjercicioList_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>(5);

        numeros.add(5);
        numeros.add(10);
        numeros.add(20);
        numeros.add(10);
        numeros.add(30);
        while (true){
            boolean encontrado = false;

            System.out.println("¿Cual número quieres buscar? ");
            System.out.println("Respuesta: ");

            while(!rl.hasNextInt()){
                System.out.println("Por favor ingrese un dato númerico: ");
                rl.next();
            }

            int respuesta = rl.nextInt();
            rl.nextLine();

            for(var i = 0; i < numeros.size(); i++){
                if(numeros.get(i).equals(respuesta)){
                    encontrado = true;
                    System.out.println("¡¡Encontrado!!: " + numeros.get(i));
                    if(numeros.get(i) == 15) {
                        Integer valorAEliminar = Integer.valueOf(10);
                        boolean fueEliminado = numeros.remove(valorAEliminar);
                        if(fueEliminado){
                            System.out.println("Se elimino la primera ocurrencia de 10.");
                            System.out.println("Lista final: " + numeros);
                            break;
                        }
                    }else{
                        if(!numeros.contains(15)){
                            numeros.add(0, 15);
                            System.out.println("Lista final: " + numeros);
                            break;
                        }
                    }
                }
            }

            if(!encontrado){
                System.out.println("Este número no se encuentra en la lista :(");
            }

            System.out.println("Quieres salir? s/n");
            String opcion = rl.nextLine();

            switch (opcion) {
                case "n":
                    System.out.println("\nOk");
                    break;
                case "s":
                    System.out.println("Hasta la proxima :)");
                    rl.close();
                    return;
                default:
                    System.out.println("Selecciona una opción valida: ");
                    rl.next();
                    break;
            }
        }
    }
}
