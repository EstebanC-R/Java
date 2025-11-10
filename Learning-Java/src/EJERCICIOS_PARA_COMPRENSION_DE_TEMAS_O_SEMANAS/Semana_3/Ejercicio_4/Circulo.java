package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_4;


public class Circulo extends FiguraGeometrica{
    private double radio;

    public Circulo(String color, double radio){
        super("Circulo", color);
        this.radio = radio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double calcularPerimetro(){
        return 2 * Math.PI * radio;
    }

    public double getRadio(){
        return radio;
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    @Override
    public String toString(){
        return String.format(
                "Figura: %s\nColor: %s\nÁrea: %.2f\nPerímetro: %.2f\nRadio: %.2f\n",
                nombre, color, calcularArea(), calcularPerimetro(), radio
        );
    }
}
