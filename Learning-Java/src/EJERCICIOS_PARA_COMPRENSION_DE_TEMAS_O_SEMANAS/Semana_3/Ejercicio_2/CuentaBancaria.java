package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_2;

public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    protected String titular;

    public CuentaBancaria(String numCuenta, double sald, String titul){
        this.numeroCuenta = numCuenta;
        this.saldo = sald;
        this.titular = titul;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto){
        saldo = saldo + monto;
    }

    public boolean retirar(double monto){
        if(saldo >= monto){
            saldo -= monto;
            return true;
        } else{
            return false;
        }
    }

    protected void mostrarEstado(){
        System.out.printf("========================= Datos Bancarios ======================");
        System.out.printf("- Numero de Cuenta :  %s\n", numeroCuenta);
        System.out.printf("- Saldo            :  %.2f$\n", saldo);
        System.out.printf("- Titular          :  %s\n ", titular);
    }

}
