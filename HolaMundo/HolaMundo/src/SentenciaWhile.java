public class SentenciaWhile {
    static void main() {
        int i = 0;
        while(i < 5){
            System.out.println(i);
            i++;
        }

        i = 0;

        boolean prueba = true;

        while(prueba){
            if(i == 7){
                prueba = false;
            }
            System.out.println("i = " + i);
            i++;
        }

        prueba = false;

        do{
            System.out.println("Se ejecuta almenos una vez"); // Se ejecuta almenos una vez
        }while (prueba);


        prueba = true;
        i = 0;
        do {
            if(i == 10){
                prueba = false;
            }
            System.out.println("i = " + i);
            i++;
        }while (prueba);
    }
}
