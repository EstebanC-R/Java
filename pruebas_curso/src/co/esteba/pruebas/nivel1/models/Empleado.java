package co.esteba.pruebas.nivel1.models;


import co.esteba.pruebas.nivel1.exceptions.SalarioInvalidoException;


public abstract class Empleado extends Persona {
    protected String puesto;
    protected double salario;

    public Empleado(int id, String nombre, int edad, String puesto, double salario) {
        super(id, nombre, edad);
        this.puesto = puesto;
        this.salario = salario;
    }

    public Empleado(int id, String nombre, int edad, String puesto) {
        super(id, nombre, edad);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario < 0){
            throw new SalarioInvalidoException("El salario no puede ser menor a 0.");
        }

        this.salario = salario;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return super.toString() +
                "\n- Puesto: " + puesto;
    }

}
