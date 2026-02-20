package co.esteba.pruebas.nivel1.models.empleados;

import co.esteba.pruebas.nivel1.models.Empleado;


public class EmpleadoPorHora extends Empleado {
    private double horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHora(int id, String nombre, int edad, String puesto, double horasTrabajadas, double tarifaPorHora) {
        super(id, nombre, edad, puesto);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    public void setTarifaPorHora(double tarifaPorHora) {
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- Horas trabajadas: " + horasTrabajadas +
                "\n- Tarifa por hora: " + tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public String obtenerRol() {
        return "Empleado por horas.";
    }


}
