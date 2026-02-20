package co.esteba.pruebas.nivel1.models.empleados;

import co.esteba.pruebas.nivel1.models.Empleado;


public class EmpleadoAsalariado extends Empleado {
    private double bono;

    public EmpleadoAsalariado(int id, String nombre, int edad, String puesto, double salario, double bono) {
        super(id, nombre, edad, puesto, salario);
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- Salario: " + salario +
                "\n- Bono: " + bono;
    }

    @Override
    public double calcularSalario() {
        return salario + bono;
    }

    @Override
    public String obtenerRol() {
        return "Empleado asalariado.";
    }
}
