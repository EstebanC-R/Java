
public class EjemploAutomovilStatic {
    public static void main(String[] args) {

        System.out.println();

        // $ Si se cambia la capacidadTanqueEstatico básicamente va a cambiar el valor final de capacidadTanqueEstatico el cual hace parte
        // $ de la propia clase.

        Automovil.setCapacidadTanqueEstatico(45);

        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setTanque(new Tanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(2.5, TipoMotor.BENCINA));
        mazda.setTipo(TipoAutomovil.PICKUP);
        // mazda.setTanque(new Tanque());
        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Tanque(50));
        nissan.setTipo(TipoAutomovil.PICKUP);
        Automovil nissan2 = new Automovil("Nissan2", "Navara2", Color.AMARILLO, new Motor(3.5, TipoMotor.DIESEL), new Tanque(50));
        nissan2.setTipo(TipoAutomovil.PICKUP);

        // # Aquí observamos como directamente distintas cosas, las cuales son:
        // $ Sobre Carga
        // * Polimorfismo

        // # La sobre carga es básicamente utilizar un mismo método pero con valores distintos, por ejemplo:
        // $ Número de parámetros.
        // $ Tipo de parámetros.
        // $ Orden de los parámetros.

        // * la capacidad de que un mismo objeto (o mejor dicho, una misma interfaz o clase base)
        // * pueda adoptar diferentes comportamientos según el contexto.


        System.out.println(subaru.detalle());
        System.out.println(mazda.detalle());
        System.out.println(nissan.detalle());
        System.out.println(nissan2.detalle());

        System.out.println();


        System.out.println("Kilometros por litros = " + Automovil.calcularConsumoEstatico(300, 60));
        System.out.println("Velocidad Maxima en Carretera = " + Automovil.VELOCIDAD_MAXIMA_CARRETERA);
        System.out.println("Velocidad Máxima en Ciudad = " + Automovil.VELOCIDAD_MAXIMA_EN_CIUDAD);


        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("Tipo subaru: " + tipoSubaru.getNombre());
        System.out.println("Tipo descripción: " + tipoSubaru.getDescripcion());

        System.out.println(mazda.calcularConsumo(300, 70));
    }
}
