package EJERCICIOS_MES_1.Semana03_Sistema_de_Empleados_con_Jerarquias;

import java.util.ArrayList;

public class ClaseLanzadora {
    public static void main(String[] args){
        ArrayList<EmpleadoEjercicio> empleados = new ArrayList<>();

        empleados.add(new EmpleadoEjercicio("Milton", 3000000.00));
        empleados.add(new Gerente("Esteban", 4000000.00, "Finanzas"));
        empleados.add(new Asistente("Bennito", 1500000.00, 4));

        for(EmpleadoEjercicio emp : empleados){
            emp.trabajar();

            if(emp instanceof Gerente gerente){
                gerente.supervisar();
            } else if(emp instanceof Asistente asistente){
                asistente.anotando();
            }
        }
    }
}
