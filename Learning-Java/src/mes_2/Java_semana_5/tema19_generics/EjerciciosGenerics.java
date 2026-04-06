package mes_2.Java_semana_5.tema19_generics;

public class EjerciciosGenerics {
    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
        ejercicio4();
        ejercicio5();
        ejercicio6();
        ejercicio7();
        ejercicio8();
        ejercicio9();
        ejercicio10();
    }

    public static void ejercicio1() {

        System.out.println("\n---------------------- EJERCICIO 1 ----------------------\n");

        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.guardar("Hola");

        Caja<Integer> cajaInteger = new Caja<>();
        cajaInteger.guardar(12);

        Caja<Double> cajaDouble = new Caja<>();
        cajaDouble.guardar(12.1231);

        System.out.printf("%-5s - %d - %.3f", cajaTexto.obtener(), cajaInteger.obtener(), cajaDouble.obtener());
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public static <T> void imprimirArray(T[] array){
        for(T elemento : array){
            System.out.println(elemento + " ");
        }

        System.out.println();
    }


    public static void ejercicio2() {
        System.out.println("\n---------------------- EJERCICIO 2 ----------------------\n");

        Integer[] arrayIntegers = {1, 2, 3, 4, 5};
        System.out.println("Array de Integer: ");
        imprimirArray(arrayIntegers);

        String[] arrayTexto = {"Hola", "Adios", "Buenas noches", "Buenos días"};
        System.out.println("Array de String: ");
        imprimirArray(arrayTexto);

        Double[] arrayDouble = {1.23, 14.234, 65.23, 1234.34, 12.34};
        System.out.println("Array de Double: ");
        imprimirArray(arrayDouble);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public static <T extends Comparable<T>> T encontrarMaximo(T[] array){
        if(array == null || array.length == 0){
            System.out.println("Error: El array no debe ser nulo o vacío.");
            return null;
        }

        T maximo = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i].compareTo(maximo) > 0){
                maximo = array[i];
            }
        }

        return maximo;
    }


    public static void ejercicio3() {
        System.out.println("\n---------------------- EJERCICIO 3 ----------------------\n");

        Integer[] numero = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        Integer maxNumero = encontrarMaximo(numero);

        System.out.println("Lista: ");
        imprimirArray(numero);
        System.out.println("El número máximo es: " + maxNumero);

        // Array de String (el máximo es el último alfabéticamente)
        String[] arrayDeStrings = {"manzana", "banana", "kiwi", "uva", "pera"};
        String maxString = encontrarMaximo(arrayDeStrings);

        System.out.print("Array de String: [manzana, banana, kiwi, pera, uva] -> ");
        System.out.println("Máximo: " + maxString); // Resultado: uva
    }


    // ------------------------------------------------------------------------------------------------------------------------

    // VA LIGADA A LA CLASE PAR
    public static void ejercicio4() {
        System.out.println("\n---------------------- EJERCICIO 4 ----------------------\n");

        Par<String, Integer> par1 = new Par<>("Edad", 25);

        System.out.println(par1);

        Par<Integer, String> par2 = new Par<>(105, "Aguacates");

        System.out.println(par2);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public static <T> void intercambiar(T[] array, int i, int j){

        if(array.length == 0 || array == null){
            System.out.println("Error: El array no debe ser nulo o vacío.");
            return;
        }
        
        if(i < 0 || i > array.length || j < 0 || j >= array.length){
            System.out.println("Error: Los indices están fuera de los limites del array");
            return;
        }

        // a) Guardar temporalmente el valor de la posición 'i'
        T temp = array[i];

        // b) Asignar el valor de la posición 'j' a la posición 'i'
        array[i] = array[j];

        // c) Asignar el valor temporal (original de 'i') a la posición 'j'
        array[j] = temp;
    }


    public static void ejercicio5() {

        System.out.println("\n---------------------- EJERCICIO 5 ----------------------\n");

        String[] letras = {"A", "B", "C", "D"};

        intercambiar(letras, 0, 3);

        imprimirArray(letras);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    // ESTA LIGADA A LA CLASE Pila
    public static void ejercicio6() {
        System.out.println("\n---------------------- EJERCICIO 6 ----------------------\n");

        Pila<Integer> pilaDeNumeros = new Pila<>();

        System.out.println("--- 1. Apilando (push) números del 1 al 5 ---");
        for(int i = 1; i <= 5; i++){
            pilaDeNumeros.push(i);
            System.out.println("Apilando: " + i);
        }

        System.out.println("\n¿Está la Pila vacía? " + pilaDeNumeros.estaVacia());
        System.out.println("Elemento superior (peek): " + pilaDeNumeros.peek()); // Debe ser 5

        System.out.println("\n--- 2. Desapilando (pop) elementos ---");

        while(!pilaDeNumeros.estaVacia()){
            Integer elementosDesapilado = pilaDeNumeros.pop();
            System.out.println("Desapilando (POP): " + elementosDesapilado);
        }

        System.out.println("\n¿Está la Pila vacia ahora? " + pilaDeNumeros.estaVacia());
    }


    // ------------------------------------------------------------------------------------------------------------------------

    public static <T> int contarOcurrencias(T[] array, T elemento){

        int contador = 0;
        
        if(array == null || array.length == 0){
            System.out.println("ERROR. Debe haber valores en la lista.");
            return 0;
        }

        for(T elementoActual : array){
            if(elemento != null && elemento.equals(elementoActual)){
                contador++;
            }

            else if(elemento == null && elementoActual == null){
                contador++;
            }
        }

        System.out.println("Número de ocurrencia del dato: " + elemento);
        System.out.println("- " + contador);

        return contador;
    }


    public static void ejercicio7() {
        System.out.println("\n---------------------- EJERCICIO 7 ----------------------\n");

        Integer[] numerosRepetidos = {1, 2, 3, 3, 4, 5, 6,7, 7, 8, 7, 7, 7, 5, 3, 2, 2, 1};

        contarOcurrencias(numerosRepetidos, 7);
    }

    // ------------------------------------------------------------------------------------------------------------------------


    public static <T> void invertirArray(T[] array){

        if (array == null || array.length <= 1) {
            System.out.println("ADVERTENCIA. El array es nulo o tiene 0/1 elemento.");
            return;
        }


        for(var i = 0; i < array.length / 2; i ++){ // i < 3;
            int j = array.length - 1 - i;          // j = 6 - 1 - 0 = 5; j = 5;
                                   // VUELTA 1                                   | VUELTA 2   j = 6 - 1 - 1; j = 4;                              |  VUELTA 3    j = 6 - 1 - 2; j = 3;
            T temp = array[i];     // temp = Java;                               | temp = JavaScript; i = 1;                                     |  temp = array[2]; temp = python;
            array[i] = array[j];   // j = RubyOnRails; array[0] = RubyOnRails;   | j = Rust; j = 4; array[1] = JavaScript; array[1] = array[4];  |  array[2] = array[3]; espacioDePython se le asigna C++;
            array[j] = temp;       // j = temp; temp = Java;                     | temp = JavaScript y array[j] = Rust; array[4] = JavaScript;   |  array[3] = array[2]; espacioDeC++ se le asigna pyhton.
        }
    }


    public static void ejercicio8() {
        System.out.println("\n---------------------- EJERCICIO 8 ----------------------\n");

        String[] lenguajesDeProgramacion = {"Java", "JavaScript", "Python", "C++", "Rust", "RubyOnRails"};

        imprimirArray(lenguajesDeProgramacion);


        invertirArray(lenguajesDeProgramacion);

        imprimirArray(lenguajesDeProgramacion);
    }

    // ------------------------------------------------------------------------------------------------------------------------

    // LA CLASE Cola ES DIRECTAMENTE LIGADA A ESTA
    public static void ejercicio9() {

        System.out.println("\n---------------------- EJERCICIO 9 ----------------------\n");

        // Creamos una Cola de Strings (nombres)
        Cola<String> colaDeNombres = new Cola<>();

        System.out.println("--- 1. Encolando (enqueue) nombres (FIFO) ---");

        colaDeNombres.encolar("Ana");   // 1º en entrar
        System.out.println("Encolado: Ana");

        colaDeNombres.encolar("Beto");  // 2º en entrar
        System.out.println("Encolado: Beto");

        colaDeNombres.encolar("Carlos");// 3º en entrar
        System.out.println("Encolado: Carlos");

        System.out.println("\nElemento al frente (verPrimero): " + colaDeNombres.verPrimero()); // Debe ser Ana

        System.out.println("\n--- 2. Desencolando (dequeue) elementos ---");

        // Desencolamos todos los elementos
        while (!colaDeNombres.estaVacia()) {
            // desencolar() devuelve el elemento al frente y lo elimina
            String nombreDesencolado = colaDeNombres.desencolar();
            System.out.println("Desencolado (FIFO): " + nombreDesencolado);
        }

        System.out.println("\n¿Está la Cola vacía ahora? " + colaDeNombres.estaVacia());
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public static <T> boolean sonIguales(T[] array1, T[] array2){
        if (array1 == null && array2 == null) {
            return true;
        }

        if (array1 == null || array2 == null) {
            System.out.println("Error: Uno de los arrays es nulo.");
            return false;
        }

        if (array1.length != array2.length) {
            System.out.println("Las listas NO son iguales: Tienen diferente longitud.");
            return false;
        }

        for (int i = 0; i < array1.length; i++) {

            // Es FUNDAMENTAL usar .equals() para comparar valores de objetos (genéricos)
            // También debemos manejar el caso de elementos nulos dentro de los arrays
            if (array1[i] == null && array2[i] != null ||
                    array1[i] != null && !array1[i].equals(array2[i])) {

                System.out.println("Las listas NO son iguales: Elemento en índice " + i + " difiere.");
                return false;
            }
            // Si ambos son null, la condición del 'if' se salta y continúa.
        }


        System.out.println("Las listas SON iguales.");
        return true;
    }
    

    public static void ejercicio10() {
        System.out.println("\n---------------------- EJERCICIO 10 ----------------------\n");

        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {1, 2, 3};
        Integer[] array3 = {1, 2, 3};
        Integer[] array4 = {1, 2, 4};
        Integer[] array5_corto = {1, 2}; // Prueba de longitud

        String[] array6 = {"H", "G", "I"};
        String[] array7 = {"H", "G", "I"};
        String[] array8 = {"H", "F", "I"};

        System.out.println("\n--- Pruebas Integer ---");
        System.out.println("Iguales {1,2,3} y {1,2,3}: " + sonIguales(array1, array2)); // True
        System.out.println("Diferentes {1,2,3} y {1,2,4}: " + sonIguales(array3, array4)); // False
        System.out.println("Diferente Longitud {1,2,3} y {1,2}: " + sonIguales(array1, array5_corto)); // False

        System.out.println("\n--- Pruebas String ---");
        System.out.println("Iguales {\"H\",\"G\",\"I\"} y {\"H\",\"G\",\"I\"}: " + sonIguales(array6, array7)); // True
        System.out.println("Diferentes {\"H\",\"G\",\"I\"} y {\"H\",\"F\",\"I\"}: " + sonIguales(array6, array8)); // False
    }
}
