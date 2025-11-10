package Java_Semana_3.tema09_Herencia;

public class TestHerencia {
    public static void main(String[] args){
        Herencia herencia = new Herencia();

        Herencia.Empleado empleado = herencia.new Empleado();
        empleado.nombre = "Esteban Ramirez";
        empleado.salario = 2500000.00;
        empleado.trabajar();

        Herencia.Gerente gerente = herencia.new Gerente();
        gerente.nombre = "Yeison Soto";
        gerente.salario = 3500000.00;
        gerente.supervisar();
        gerente.supervisar();
    }
}
