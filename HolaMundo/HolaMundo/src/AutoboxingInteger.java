public class AutoboxingInteger {
    static void main() {

        Integer[] enteros = {Integer.valueOf(1), 2 ,3 ,4 ,5 ,6 , 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int suma = 0;

        // Esta forma es la explicíta de tal forma que hace el Autoboxing en la forma implicíta.
        for(Integer item : enteros){
            if( item.intValue() % 2 == 0){
                suma += item.intValue();
            }
        }
        System.out.println("suma = " + suma);

        suma = 0;

        // Aquí lo que pasa es que básicamente hace el Autoboxing de forma implícita, de forma que no lo vemos, pero por detrás pasa lo del for de arriba.
        for(Integer item : enteros){
            if( item % 2 == 0){
                suma += item;
            }
        }

        System.out.println("suma = " + suma);


    }
}
