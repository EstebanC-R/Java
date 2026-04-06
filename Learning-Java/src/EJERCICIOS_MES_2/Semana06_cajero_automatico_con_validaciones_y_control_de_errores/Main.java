package EJERCICIOS_MES_2.Semana06_cajero_automatico_con_validaciones_y_control_de_errores;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        GetorCuentas gestor = new GetorCuentas();
        Menu.menu(rl, gestor);
    }
}
