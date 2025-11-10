package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_1;

public class Camion extends Vehiculo{
    double capacidadCarga;

    public Camion(String brand, String model, int year, double capacidadCarga){
        super(brand, model, year);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void acelerar(){
        System.out.println("TUUUUUUUUUUUUUUUUUUUUU ACELERANDO CAMIONNNN");
    }
}
