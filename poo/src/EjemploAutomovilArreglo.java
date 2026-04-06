import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {

        Persona conductorSubaru = new Persona("Luci", "Martínez");
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setTanque(new Tanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductorSubaru);


        Persona pato = new Persona("Pato", "Rodrigez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(2.5, TipoMotor.BENCINA));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setTanque(new Tanque());
        mazda.setConductor(pato);



        Persona bea = new Persona("Bea", "Gonzales");
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Tanque(50));
        nissan.setConductor(bea);
        nissan.setTipo(TipoAutomovil.PICKUP);


        Persona lalo = new Persona("Lalo", "Mena");
        Automovil suzuki = new Automovil("Suzuki", "Vitara", Color.AZUL, new Motor(1.6, TipoMotor.DIESEL), new Tanque(50));
        suzuki.setConductor(lalo);
        suzuki.setTipo(TipoAutomovil.SUV);

        Automovil audi = new Automovil("Audi", "A3");
        audi.setConductor(new Persona("Jano", "Pérez"));

        Automovil[] autos = new Automovil[5];
        autos[0] = subaru;
        autos[1] = mazda;
        autos[2] = nissan;
        autos[3] = suzuki;
        autos[4] = audi;

        Arrays.sort(autos);
        for(Automovil a : autos){
            System.out.println(a);
        }

    }
}
