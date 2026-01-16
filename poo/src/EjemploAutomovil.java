import java.util.Date;

public class EjemploAutomovil {
    public static void main(String[] args) {

        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setTanque(new Tanque());

        Automovil mazda = new Automovil("Mazda", "BT-50", Color.ROJO, new Motor(3.0, TipoMotor.DIESEL));
        System.out.println("Fabricante Mazda = " + mazda.getFabricante());
        mazda.setTanque(new Tanque(45));

        Automovil nissan = new Automovil("Nissan", "Navara", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Tanque(50));
        Automovil nissan2 = new Automovil("Nissan", "Navara", Color.AMARILLO, new Motor(3.5, TipoMotor.BENCINA), new Tanque(50));

        Automovil auto = new Automovil();
        Date fecha = new Date();

        System.out.println("Son iguales? = " + (nissan == nissan2));
        System.out.println("Son iguales con equals? = " + (nissan.equals(nissan2)));
        System.out.println("\n Son iguales auto y fecha = " + auto.equals(fecha));



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

        System.out.println(subaru.acelerarFrenar(3000));
        System.out.println("Kilómetros por litro = " + subaru.calcularConsumo(300, 0.6f));
        System.out.println();


        System.out.println(mazda.acelerarFrenar(4000));
        System.out.println("Kilómetros por litro = " + subaru.calcularConsumo(300, 60));
        System.out.println();


        System.out.println(nissan.acelerarFrenar(4000));
        System.out.println("Kilómetros por litro = " + nissan.calcularConsumo(300, 60));
        System.out.println();


        System.out.println(nissan);
    }
}
