package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_4;

public class Rectangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    public Rectangulo(String color,double base, double altura){
        super("Rectángulo", color);
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea(){
        return base * altura;
    }

    @Override
    public double calcularPerimetro(){
        return 2 * (base + altura);
    }

    public double getBase(){
        return base;
    }

    public void setBase(double base){
        this.base = base;
    }

    public double getAltura(){
        return altura;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    @Override
    public String toString(){
        return String.format(
                "Figura: %s\nColor: %s\nÁrea: %.2f\nPerímetro: %.2f\nAltura: %.2f\nBase: %.2f\n",
                nombre, color, calcularArea(), calcularPerimetro(), altura, base
        );
    }
}
