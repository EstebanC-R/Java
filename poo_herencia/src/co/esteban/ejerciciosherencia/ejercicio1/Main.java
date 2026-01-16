package co.esteban.ejerciciosherencia.ejercicio1;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n======================= Clase Persona =======================");
        Persona persona = new Persona("Milton", "Castaño", "11223", "CR 40 D Cl 107 A-33");

        System.out.println(persona);

        System.out.println("\n======================= Clase Empleado =======================");

        Empleado empleado = new Empleado("Milton", "Castaño", "12323", "CR 42 D Cl 107 A-33", 2000000);
        System.out.println("\n- Salario sin aumento: " + empleado.getRemuneracion() + "\n- Empleado ID: " + empleado.getEmpleadoId());
        empleado.aumentarRemuneracion(12);
        System.out.println(empleado);

        Empleado empleado2 = new Empleado("Pepe", "El Blanco", "22344", "CR 42 D Cl 107 A-33", 7000000);
        System.out.println("\n- Salario sin aumento: " + empleado2.getRemuneracion() + "\n- Empleado ID: " + empleado2.getEmpleadoId());
        empleado2.aumentarRemuneracion(9);
        System.out.println(empleado2);

        System.out.println("\n======================= Clase Gerente =======================");
        Gerente gerente = new Gerente("Milton", "Castaño", "12323", "CR 48 D Cl 107 A-32", 2000000, 5000000);
        System.out.println(gerente);
        gerente.setPresupuesto(6000000);
        System.out.println(gerente);

        System.out.println("\n======================= Clase Cliente =======================");
        Cliente cliente = new Cliente("Milton", "Castaño", "11223", "CR 41 D Cl 107 A-33");
        System.out.println(cliente);

    }
}
