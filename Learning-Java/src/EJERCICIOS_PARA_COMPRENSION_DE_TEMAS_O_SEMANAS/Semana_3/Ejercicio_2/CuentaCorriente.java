package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_2;

public class CuentaCorriente extends CuentaBancaria{
    private double sobregiro;

    public CuentaCorriente(String numCuenta, double saldo, String titular, double sobregiro){
        super(numCuenta, saldo, titular);
        this.sobregiro = sobregiro;
    }

    @Override
    public boolean retirar(double monto){
        if(sobregiro > 10000){
            System.out.println("⚠️ Sobregiro no permitido: excede el límite de seguridad.");
            return false;
        }

        double disponible = getSaldo() + sobregiro;

        if(monto <= disponible){
            setSaldo(getSaldo() - monto);
            return true;
        } else{
            System.out.println("❌ Retiro rechazado: monto excede el saldo + sobregiro.");
            return false;
        }
    }

    @Override
    protected void mostrarEstado(){
        System.out.printf("========================= Datos Bancarios Cuenta Corriente ======================\n");
        System.out.printf("- Numero de Cuenta :  %s\n", super.getNumeroCuenta());
        System.out.printf("- Saldo            :  %.2f$\n", getSaldo());
        System.out.printf("- Titular          :  %s\n ", super.getTitular());
        System.out.printf("- Sobregiro máximo :  %.2f\n ", sobregiro);
    }
}
