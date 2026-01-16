
public class EjemploAutomovilEnum {
    public static void main(String[] args) {

        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.DIESEL));
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setTanque(new Tanque());

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(2.5, TipoMotor.BENCINA));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setTanque(new Tanque(45));

        TipoAutomovil tipo = subaru.getTipo();
        System.out.println("Tipo subaru: " + tipo.getNombre());
        System.out.println("Tipo descripción: " + tipo.getDescripcion());

        tipo = mazda.getTipo();

        switch (tipo){
            case CONVERTIBLE ->
                System.out.println("El automóvil es deportivo y descapotable de dos puertas.");
            case COUPE ->
                System.out.println("Es un automóvil pequeño de dos puertas y típicamente deportivo");
            case FURGON ->
                System.out.println("Es un automobile utilitario de transporte, de empresas.");
            case HATCHBACK ->
                System.out.println("Es un automóvil mediano compacto, aspecto deportivo");
            case PICKUP ->
                System.out.println("Es un automóvil de doble cabina o camionera.");
            case SEDAN ->
                System.out.println("Es un automóvil mediano.");
            case STATION_WAGON ->
                System.out.println("Es un automóvil más grande, con maleta grande...");
        }

        System.out.println();

        TipoAutomovil[] tipos = TipoAutomovil.values();

        for(TipoAutomovil ta : tipos){
            System.out.print(ta + " => " + ta.name() + ", " + ta.getNombre() +  ", " + ta.getDescripcion() + ", " + ta.getNumeroPuertas());
            System.out.println();
        }
    }
}
