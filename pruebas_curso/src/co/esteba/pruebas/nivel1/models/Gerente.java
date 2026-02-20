package co.esteba.pruebas.nivel1.models;

import co.esteba.pruebas.nivel1.models.empleados.EmpleadoAsalariado;


public class Gerente extends EmpleadoAsalariado {

    public Gerente(int id, String nombre, int edad, String puesto, double salario, double bono) {
        super(id, nombre, edad, puesto, salario, bono);
    }
}
