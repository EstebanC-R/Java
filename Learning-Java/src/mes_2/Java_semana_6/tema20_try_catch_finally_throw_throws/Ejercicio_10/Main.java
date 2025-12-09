package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_10;

import java.util.Scanner;

public class Main {
    public static double saldo;


    public static void ingresarSaldo(double ingresoSaldo) throws Exception{
        if (ingresoSaldo < 100){
            throw new Exception("No puedes ingresar "+ ingresoSaldo + " minimo desde 400.");
        }

        saldo += ingresoSaldo;
    }

    public static void retirarSaldo(double retirar) throws Exception{
        if(retirar > saldo){
            throw new Exception("No puedes retirar más que tú saldo actual: " + saldo);
        }

        saldo -= retirar;
    }

    public static void mostrarSaldo(){
        System.out.println("Tú saldo actual es de: " + saldo);
    }

    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        saldo = 2000.00;

        while(true){
            System.out.println("¿Quieres ingresar, retirar dinero, ver tú saldo o salir? \n- 1. Ingresar \n- 2. Retirar \n- 3. Saldo \n- 4. Salir \n- Respuesta:");
            String opcion = rl.nextLine();

            int numeroOpcion = 0;

            try {
                numeroOpcion = Integer.parseInt(opcion);
            }catch (NumberFormatException e){
                System.out.println("ERROR en el proceso.");
                System.out.println("Mensaje: " + e.getMessage());
            }

            switch (numeroOpcion){
                case 1:
                    System.out.println("¿Cuanto quieres ingresar?: ");

                    while(!rl.hasNextDouble()){
                        System.out.println("Por favor ingrese un valor númerico: ");
                        rl.next();
                    }
                    double ingreso = rl.nextDouble();
                    try{
                        ingresarSaldo(ingreso);
                    }catch (Exception e){
                        System.out.println("Mensaje: " + e.getMessage());
                    }finally {
                        System.out.println("Operación finalizada.");
                    }
                    rl.nextLine();
                    break;
                case 2:
                    System.out.println("Ingresa el valor a retirar: ");
                    while(!rl.hasNextDouble()){
                        System.out.println("Por favor ingrese un valor númerico: ");
                        rl.next();
                    }
                    double retiro = rl.nextDouble();
                    try {
                        retirarSaldo(retiro);
                    }catch (Exception e){
                        System.out.println("Mensaje: " + e.getMessage());
                    }finally {
                        System.out.println("Operación finalizada.");
                    }
                    rl.nextLine();
                    break;
                case 3:
                    mostrarSaldo();
                    break;
                case 4:
                    rl.close();
                    return;
                default:
                    System.out.println("Por favor seleccione una respuesta valida 1 - 4.");
                    rl.nextLine();
                    break;
            }
        }
    }
}
