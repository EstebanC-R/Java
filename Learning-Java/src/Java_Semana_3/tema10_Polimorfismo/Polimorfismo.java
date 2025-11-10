package Java_Semana_3.tema10_Polimorfismo;

public class Polimorfismo {

    // Clase Padre
    public static class Animal{
        public void hacerSonido(){
            System.out.println("El animal hace un sonido");
        }
    }


    // Clase Hija 1
    public static class Perro extends Animal{
        @Override
        public void hacerSonido() {
            System.out.println("🐕‍🦺 El perro dice:  ¡¡Guau!! ");
        }
    }


    // Clase Hija 2
    public static class Gato extends Animal {
        @Override
        public void hacerSonido(){
            System.out.println("🐈 El gato dice: ¡¡Miau!! ");
        }
    }


    // Clase Hija 3
    public static class Vaca extends Animal {
        @Override
        public void hacerSonido(){
            System.out.println("🐄 La vaca dice: ¡¡Muuu!! ");
        }
    }
}
