package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_4;

// Clase abstracta
public abstract class FiguraGeometrica {
    protected String nombre;
    protected String color;

    public FiguraGeometrica(String nombre, String color){
        this.nombre = nombre;
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    // Métodos abstractos, esto significan que no tienen cuerpo y que si al menos hay uno
    // Entonces también toda la clase debe ser abstracta.

    public abstract double calcularArea();
    public abstract double calcularPerimetro();


    public void mostrarInformacion(){
        System.out.printf("- Figura                 : %s\n", nombre);
        System.out.printf("- Área                   : %.2f\n", calcularArea());
        System.out.printf("- Perímetro              : %.2f\n", calcularPerimetro());
        System.out.printf("- Color                  : %s\n", color);
    }

    @Override
    public String toString(){
        return String.format(
                "Figura: %s\nColor: %s\nÁrea: %.2f\nPerímetro: %.2f\n",
                nombre, color, calcularArea(), calcularPerimetro()
        );
    }
}
