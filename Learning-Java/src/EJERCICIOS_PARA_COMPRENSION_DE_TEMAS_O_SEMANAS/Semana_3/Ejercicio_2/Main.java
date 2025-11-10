package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_2;

public class Main {
    public static void main(String[] args){
        CuentaAhorros cuenta1 = new CuentaAhorros("4862887", 1000.00, "Milton", 0.05);
        CuentaCorriente cuentaAho1 = new CuentaCorriente("1023423", 500.00, "Esteban", 11000);

        // -------------------------- Cuenta 1 Cuenta de Ahorros----------------------
        cuenta1.mostrarEstado();
        cuenta1.depositar(4000.00);
        cuenta1.mostrarEstado();

        cuenta1.retirar(2000.00);
        cuenta1.mostrarEstado();

        cuenta1.aplicarInteres();
        cuenta1.mostrarEstado();

        System.out.println("\n");
        System.out.println("\n");

        // -------------------------- Cuenta Corriente 1 -----------------
        cuentaAho1.mostrarEstado();
        cuentaAho1.depositar(1000.00);
        cuentaAho1.mostrarEstado();

        cuentaAho1.retirar(300.00);
        cuentaAho1.mostrarEstado();

    }
}
