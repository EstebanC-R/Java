
public class EjemploAutomovilRelacionesObjetos {
    public static void main(String[] args) {

        Persona conductorSubaru = new Persona("Luci", "Martínez");
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setTanque(new Tanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductorSubaru);
        // subaru.setRuedas(ruedasSub);

        Rueda[] ruedasSub = new Rueda[10];

        for(int i = 0; i < ruedasSub.length; i++){
            subaru.addRueda(new Rueda("Yokohama", 16, 7.5));
        }

        Persona pato = new Persona("Pato", "Rodrigez");
        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(2.5, TipoMotor.BENCINA));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setTanque(new Tanque());
        mazda.setConductor(pato);
        // mazda.setRuedas(ruedasMaz);

        Rueda[] ruedasMaz = new Rueda[5];
        for(int i = 0; i < ruedasMaz.length; i++){
            mazda.addRueda( new Rueda("Michelin", 18, 10.5));
        }


        Persona bea = new Persona("Bea", "Gonzales");
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Tanque(50));
        nissan.setConductor(bea);
        nissan.setTipo(TipoAutomovil.PICKUP);

        nissan.addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5))
                .addRueda(new Rueda("Pirelli", 20, 11.5));


        Rueda[] ruedasNiss2 = {
                new Rueda("Pirelli", 20, 11.5),
                new Rueda("Pirelli", 20, 11.5),
                new Rueda("Pirelli", 20, 11.5),
                new Rueda("Pirelli", 20, 11.5),
                new Rueda("Pirelli", 20, 11.5),
        };
        Persona lalo = new Persona("Lalo", "Mena");
        Automovil nissan2 = new Automovil("Nissan2", "Navara2", Color.AMARILLO, new Motor(3.5, TipoMotor.DIESEL), new Tanque(50), lalo, ruedasNiss2);
        nissan2.setTipo(TipoAutomovil.PICKUP);


        System.out.println(subaru.detalle());
        System.out.println(mazda.detalle());
        System.out.println(nissan.detalle());
        System.out.println(nissan2.detalle());

        System.out.println();

        /*System.out.println("Conductor Subaru: " + subaru.getConductor());
        System.out.println(" ------- Ruedas Subaru ------- ");
        for(Rueda r: subaru.getRuedas()){
            System.out.println(r.getFabricante() + ", Aro: " + r.getAro() + ", Ancho: " + r.getAncho());
        }*/
    }
}
