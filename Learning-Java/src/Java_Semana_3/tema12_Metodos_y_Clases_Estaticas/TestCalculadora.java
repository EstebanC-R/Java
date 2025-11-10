package Java_Semana_3.tema12_Metodos_y_Clases_Estaticas;

public class TestCalculadora {

    // Aquí no se hace new Calculadora(). Simplemente usaste la clase como si fuera una caja de herramientas.

    public static void main(String[] args){
        int resultado = Calculadora.sumar(3, 4);
        System.out.println("\nEl resultado es: " + resultado);
    }
}
