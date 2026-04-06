package mes_1.Java_Semana_2.tema06_Constructores;

public class Mascotas {
    public static void main(String[] args){
        ConstructorDescripcionDeMascota nuevaMascota = new ConstructorDescripcionDeMascota("Pepe", "Blanco con Naranja",
            "Es tranquilo, jugueton y sobre todo tiene un gran sentido de protección", 11, 30
        );

        nuevaMascota.mensajeCompleto();
    }
}
