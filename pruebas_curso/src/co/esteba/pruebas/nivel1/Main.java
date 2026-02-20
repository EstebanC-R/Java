package co.esteba.pruebas.nivel1;

import co.esteba.pruebas.nivel1.exceptions.EmpleadoDuplicadoException;
import co.esteba.pruebas.nivel1.exceptions.UsuarioNoEncontradoException;
import co.esteba.pruebas.nivel1.models.Empleado;
import co.esteba.pruebas.nivel1.models.Gerente;
import co.esteba.pruebas.nivel1.models.empleados.EmpleadoAsalariado;
import co.esteba.pruebas.nivel1.models.empleados.EmpleadoPorHora;

import java.util.*;

public class Main {
    static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {

        Empleado empleado = new EmpleadoPorHora(1, "Milton", 22, "Programador", 48, 60000);
        Empleado empleado3 = new EmpleadoAsalariado(2, "Castaño", 22, "QI", 3000000, 200000);
        Empleado empleado4 = new Gerente(3, "Ramirez", 26, "Gerente de ATTSDD", 5000000, 400000);

        addEmpleado(empleado);
        addEmpleado(empleado3);
        addEmpleado(empleado4);

        double nominaTotal = empleados.stream().mapToDouble(Empleado::calcularSalario).sum();
        System.out.printf("Nomina Total: %.0f", nominaTotal);

        int encontrarId = 2;
        System.out.println("\n------- Encontrar por ID -------");
        System.out.println(buscarId(encontrarId).orElseThrow(() -> new UsuarioNoEncontradoException("No se encontró el usuario.")));

        System.out.println("\n------- Ordenando por Salario -------");

        empleados.sort((a, b) -> Double.compare(b.calcularSalario(), a.calcularSalario()));
        empleados.forEach(System.out::println);

    }

    public static void addEmpleado(Empleado e){
        if(e != null){
            for(Empleado empl: empleados){
                if(empl.getId() == e.getId()){
                    System.out.println();
                    throw new EmpleadoDuplicadoException("No se puede agregar debido a que este ID ya existe = " + e.getId() + " " + e.getNombre() + " - " + empl.getId() + " " + empl.getNombre());
                }
            }
            empleados.add(e);
        }
    }

    public static Optional<Empleado> buscarId(int id){
        return empleados.stream().filter(e -> e.getId() == id).findFirst();
    }
}
