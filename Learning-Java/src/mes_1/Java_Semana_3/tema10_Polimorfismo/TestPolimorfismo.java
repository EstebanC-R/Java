package mes_1.Java_Semana_3.tema10_Polimorfismo;

public class TestPolimorfismo {
    public static void main(String[] args){
        Polimorfismo.Animal miAnimal;

        miAnimal = new Polimorfismo.Perro();
        miAnimal.hacerSonido();

        miAnimal = new Polimorfismo.Gato();
        miAnimal.hacerSonido();

        miAnimal = new Polimorfismo.Vaca();
        miAnimal.hacerSonido();
    }
}
