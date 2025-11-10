package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_1;

public class Vehiculo {
    private String marca;
    private String modelo;
    private int year;

    public Vehiculo(String brand, String model, int year){
        this.marca = brand;
        this.modelo = model;
        this.year = year;
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getYear(){
        return year;
    }

    public void acelerar(){
        System.out.println("fiuuuuuuumbbaaa");
    }

    public void frenar(){
        System.out.println("eeeeeeeeehhhhh ssssss");
    }
}
