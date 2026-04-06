package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_1;

public class Moto extends Vehiculo{
    boolean tieneSideCar;

    public Moto(String brand, String model, int year, boolean tieneSideCar){
        super(brand, model, year);
        this.tieneSideCar = tieneSideCar;
    }

    @Override
    public void acelerar(){
        System.out.println("BRUUUUUUUMM ACELERANDO MOOTOOOO");
    }
}
