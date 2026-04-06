package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Vehiculo> auto = new ArrayList<>();
        auto.add(new Auto("Chevrolet", "X-2", 2015, 2));
        auto.add(new Auto("Nizzan", "TRKHJ", 2018, 4));

        auto.add(new Moto("Ninja", "TRLK-1231", 2020, true));
        auto.add(new Moto("Pulsar", "NX", 2021, false));

        auto.add(new Camion("Toyota", "W-T", 2000, 2000.00));
        auto.add(new Camion("Suzuki", "QWSD", 2010, 1500.00));


        for(Vehiculo vehi : auto){
            if(vehi instanceof Auto aut){
                aut.acelerar();
            } else if(vehi instanceof Moto moto){
                moto.acelerar();
            } else if(vehi instanceof Camion camion){
                camion.acelerar();
            }
        }
    }
}
