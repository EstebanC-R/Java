package EJERCICIOS_MES_1.Semana03_Sistema_de_Empleados_con_Jerarquias;

public class EmpleadoEjercicio {
    private String nombre;
    private double salario;


    public EmpleadoEjercicio(String nom, double salar){
        this.nombre = nom;
        this.salario = salar;
    }

    public String getNombre(){
        return nombre;
    }

    public double getSalario(){
        return salario;
    }

    public void trabajar(){
        System.out.println("\n" + nombre + " está trabajando.");
    }

    @Override
    public String toString(){
        return "\n- Nombre: " + nombre + "\n- Salario: " + salario;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        EmpleadoEjercicio otro = (EmpleadoEjercicio) obj;
        return nombre.equals(otro.nombre) && salario == (otro.salario);
    }

    @Override
    public int hashCode(){
        int resultado = nombre.hashCode();
        long salarioBits = Double.doubleToLongBits(salario);
        resultado = 31 * resultado + (int)(salarioBits ^ (salarioBits >>> 32));

        return resultado;
    }
}
