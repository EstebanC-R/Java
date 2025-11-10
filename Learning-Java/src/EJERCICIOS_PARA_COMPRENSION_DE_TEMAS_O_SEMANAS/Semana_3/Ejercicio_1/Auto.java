package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_1;

public class Auto extends Vehiculo {
    int numeroDePuertas;

    public Auto(String brand, String model, int year, int numPuertas){
        super(brand, model, year);
        this.numeroDePuertas = numPuertas;
    }

    @Override
    public void acelerar(){
        System.out.println("Acerleraaaaandoooo AUTOOOOOOOOO");
    }
}
