package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_4;

public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(String color, double base, double altura){
        super("Triángulo", color);
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea(){
        return (base * altura) / 2;
    }

    @Override
    public double calcularPerimetro(){
        double lado = Math.sqrt(Math.pow(base / 2, 2) + Math.pow(altura, 2));
        return base + 2 * lado;
    }

    @Override
    public String toString(){
        return String.format(
                "Figura: %s\nColor: %s\nÁrea: %.2f\nPerímetro: %.2f\nAltura: %.2f\nBase: %.2f\n",
                nombre, color, calcularArea(), calcularPerimetro(), altura, base
        );
    }
}
