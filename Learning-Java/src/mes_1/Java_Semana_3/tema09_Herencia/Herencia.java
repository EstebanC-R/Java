package mes_1.Java_Semana_3.tema09_Herencia;

public class Herencia {
    class Empleado{
        String nombre;
        double salario;

        void trabajar(){
            System.out.println("\n" + nombre + " Esta trabajando. Actualmente tiene un salarío de: " + salario);
        }
    }

    class Gerente extends Empleado{
        void supervisar(){
            System.out.println("\n" + nombre + " está supervisando al equipo. Su salario es de: "+ salario);
        }
    }
}
