package EJERCICIOS_MES_2.Semana06_cajero_automatico_con_validaciones_y_control_de_errores;

public class Cajero {
    private String nombre;
    private String codigoAcceso;
    private long cedula;
    private double dinero = 0;

    public Cajero(String nombre, String codigoAcceso, long cedula){
        this.nombre = nombre;
        this.codigoAcceso = codigoAcceso;
        this.cedula = cedula;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCodigoAcceso(){
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso){
        this.codigoAcceso = codigoAcceso;
    }

    public long getCedula(){
        return cedula;
    }

    public void setCedula(long cedula){
        this.cedula = cedula;
    }

    public double getDinero(){
        return dinero;
    }

    public void setDinero(double dinero){
        this.dinero = dinero;
    }

    public int retirar(double cantidadRetirar, String codigoIngresado){
        if(!this.codigoAcceso.equals(codigoIngresado)){
            System.out.println("**ERROR**\n- Codigo de acceso incorrecto.");
            return -1;
        }

        if(cantidadRetirar > this.dinero){
            System.out.println("**ERROR**\n- Saldo insuficiente. Saldo actual: " + this.dinero);
            return -1;
        }

        if(cantidadRetirar <= 0){
            System.out.println("**ERROR**\n- El monto a retirar debe ser positivo.");
            return -1;
        }

        this.dinero -= cantidadRetirar;
        System.out.println("Retiro exitoso. Nuevo saldo: " + this.dinero);
        return 1;
    }

    public int ingresarDinero(double dineroIngresado){
        if(dineroIngresado <= 0 || dineroIngresado < 2000){
            System.out.println("El monto mínimo de ingreso debe ser $2000.");
            return -1;
        }

        this.dinero += dineroIngresado;
        System.out.println("Dinero ingresado correctamente!!");
        System.out.println("Saldo ingresado: " + dineroIngresado);
        System.out.println("Nuevo saldo: " + this.dinero);
        return 1;
    }

    public void mostrarSaldo(){
        System.out.println(getDinero());
    }



    @Override
    public String toString(){
        return String.format("\n---------------------------------\n%-15s : %s\n%-15s : %d\n%s",
                "Nombre", nombre,
                "Cédula", cedula,
                "---------------------------------\n"
        );
    }
}
