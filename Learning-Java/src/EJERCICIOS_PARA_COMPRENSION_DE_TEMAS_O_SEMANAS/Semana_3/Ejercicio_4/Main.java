package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_4;

public class Main {
    public static void main(String[] args){
        // Opción 1: menú interactivo
        Menu.menu();

        // Opción 2: recorrido automático de figuras
        FiguraGeometrica[] figuras = {
                new Circulo("Rojo", 5),
                new Rectangulo("Azul", 10, 4),
                new Triangulo("Verde", 6, 8)
        };

        double areaTotal = 0;

        for (FiguraGeometrica figura : figuras){
            System.out.println(figura); // usa toString()
            areaTotal += figura.calcularArea();
            System.out.println("-----------------------------");
        }

        System.out.printf("Área total de todas las figuras: %.2f\n", areaTotal);
    }
}
