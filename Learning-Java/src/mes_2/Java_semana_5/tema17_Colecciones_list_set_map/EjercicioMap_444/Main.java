package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioMap_444;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        Map<String, Double> saldosClientes = new HashMap<>();

        saldosClientes.put("ClienteA", 500.00);
        saldosClientes.put("ClienteB", 200.00);

        System.out.println("\n --------- Clientes ------------ ");
        System.out.println(saldosClientes);


        String ClienteC = "ClienteC";

        if(!saldosClientes.containsKey(ClienteC)){
            saldosClientes.put(ClienteC, 100.0);
        }else{
            System.out.println("\n " + ClienteC + " ya existía. ");
        }

        String ClienteA = "ClienteA";

        if(saldosClientes.containsKey(ClienteA)){
            Double saldoActual = saldosClientes.get(ClienteA);

            Double nuevoSaldo = saldoActual * 2;

            saldosClientes.put(ClienteA, nuevoSaldo);

            System.out.println("\n Actualizado: Saldo de " + ClienteA + " es " + nuevoSaldo);
        }

        System.out.println("\n ----------------- Map Final -----------------");
        System.out.println(saldosClientes);
    }
}
