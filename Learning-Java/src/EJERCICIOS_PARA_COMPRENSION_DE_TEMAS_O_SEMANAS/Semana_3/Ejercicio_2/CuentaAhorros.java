package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_2;

public class CuentaAhorros extends CuentaBancaria{
    private double tasaInteres;


    public CuentaAhorros(String numCuenta, double saldo, String titular, double tasaInt){
        super(numCuenta, saldo, titular);
        this.tasaInteres = tasaInt;
    }

    public void aplicarInteres(){
        double interesGenerado = getSaldo() * tasaInteres;
        setSaldo(getSaldo() + interesGenerado);
    }

    @Override
    protected void mostrarEstado(){
        System.out.printf("========================= Datos Bancarios Cuenta de Ahorros ======================\n");
        System.out.printf("- Numero de Cuenta :  %s\n", super.getNumeroCuenta());
        System.out.printf("- Saldo            :  %.2f$\n", getSaldo());
        System.out.printf("- Titular          :  %s\n", super.getTitular());
        System.out.printf("- Tasa de Interés  :  %.2f%%\n", tasaInteres * 100);
    }

}
