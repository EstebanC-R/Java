package mes_2.Java_semana_5.tema18_iteradores_y_bucles_sobre_colecciones;

import java.util.*;

public class EjerciciosIteradores {
    public static void Ejercicio1() {
        System.out.println("\n ---------- EJERCICIO 1 ----------");

        List<Integer> numeros = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );

        var e = 0;
        for (Integer i : numeros) {
            e += i;
        }

        System.out.println("El total es: " + e);
    }

    public static void Ejercicio2() {
        System.out.println("\n ---------- EJERCICIO 2 ----------");

        List<String> nombres = new ArrayList<>(
                Arrays.asList("Milton", "Daniel", "Yeison", "Yony", "Mateo")
        );

        for(var i =0; i < nombres.size(); i++){
            System.out.println(nombres.get(nombres.size() - (i + 1)));
        }
    }

    public static void Ejercicio3() {
        System.out.println("\n ---------- EJERCICIO 3 ----------");
        List<String> productos = new ArrayList<>(
                Arrays.asList("Carro", "Moto", "Celulares", "Nevera", "Casa", "Computador")
        );

        for(String p : productos){
            if(p.length() > 5){
                System.out.println("- " + p);
            }
        }
    }

    public static void Ejercicio4() {
        System.out.println("\n ---------- EJERCICIO 4 ----------");

        List<Integer> numeros = new ArrayList<>(
                Arrays.asList(1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
        );

        Iterator<Integer> it = numeros.iterator();

        while(it.hasNext()){
            Integer num = it.next();
            if(num % 2 == 0){
                it.remove();
            }
        }

        System.out.println(numeros);
    }

    public static void Ejercicio5() {
        System.out.println("\n ---------- EJERCICIO 5 ----------");

        List<String> nombres = new ArrayList<>(
                Arrays.asList("Ana", "Luis", "Juan", "María", "Pedro" )
        );

        Iterator<String> it = nombres.iterator();

        while(it.hasNext()){
            String nom = it.next();
            if(nom.equals("Juan")){
                System.out.println("El nombre Juan si Exite");
                return;
            }
        }

        System.out.println("El nombre Juan no se ha encontrado.");
    }

    public static void Ejercicio6() {
        System.out.println("\n ---------- EJERCICIO 6 ----------");

        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(5);
        numeros.add(10);
        numeros.add(15);
        numeros.add(20);
        numeros.add(25);

        System.out.println("\nNúmeros originales = " + numeros);

        for(var i = 0; i < numeros.size(); i++){
            var numeroActual = numeros.get(i);
            var nuevoNumero = numeroActual * 2;

            numeros.set(i, nuevoNumero);
        }

        System.out.println("Nueva Lista: " + numeros);
    }

    public static void Ejercicio7() {
        System.out.println("\n ---------- EJERCICIO 7 ----------");

        Map<String, Integer> productos = new HashMap();

        productos.put("manzanas", 10);
        productos.put("peras", 5);
        productos.put("naranjas", 8);

        for(Map.Entry<String, Integer> valores : productos.entrySet()){
            System.out.println("- Producto: " + valores.getKey() + "\n- Cantidad: " + valores.getValue() + "\n");
        }
    }

    public static void Ejercicio8() {
        System.out.println("\n ---------- EJERCICIO 8 ----------");
        Map<String, Double> productos = new HashMap<>();

        productos.put("Salchica", 2000.00);
        productos.put("Arepas", 3000.00);
        productos.put("Queso", 4000.00);

        for(Map.Entry<String, Double> prod : productos.entrySet()){
            prod.setValue(prod.getValue() + 3);
        }

        System.out.println(productos);
    }

    public static void Ejercicio9() {
        System.out.println("\n ---------- EJERCICIO 9 ----------");

        Map<String, Integer> carros = new HashMap<>();

        carros.put("Toyota", 6);
        carros.put("Chevrolet", 3);
        carros.put("Lamborgini", 1);
        carros.put("Mazda", 20);
        carros.put("Mercedes-Benz", 20);

        System.out.println(carros);

        Iterator<Map.Entry<String, Integer>> it  = carros.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entrada = it.next();

            if(entrada.getValue() > 5){
                it.remove();
            }
        }

        System.out.println(carros);
    }

    public static void Ejercicio10() {
        System.out.println("\n ---------- EJERCICIO 10 ----------");

        Map<String, Double> productos = new HashMap<>();

        productos.put("Laptop", 1200.50);
        productos.put("Mouse", 25.99);
        productos.put("Teclado", 75.00);
        productos.put("Monitor", 300.00);

        var precioMaximo = -1.0;
        var productoMasCaro = "";

        Iterator<Map.Entry<String, Double>> it = productos.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Double> entrada = it.next();
            var precioActual = entrada.getValue();
            var productoActual = entrada.getKey();

            if(precioActual > precioMaximo){
                precioMaximo = precioActual;
                productoMasCaro = productoActual;
            }
        }

        System.out.println("El producto más caro es: ");
        System.out.println("- " + productoMasCaro + ": " +  "$" + precioMaximo);
    }

    public static void Ejercicio11() {
        System.out.println("\n ---------- EJERCICIO 11 ----------");

        Set<Integer> numeros = new HashSet<>(
                Arrays.asList(1,2,3,4,5,2,1)
        );

        System.out.println(numeros);
    }

    public static void Ejercicio12() {
        System.out.println("\n ---------- EJERCICIO 12 ----------");

        Set<String> letras = new HashSet<>(
                Arrays.asList("a", "b", "c", "d", "e", "f", "g")
        );

        Iterator<String> it = letras.iterator();

        while(it.hasNext()){
            String letter = it.next();
            if(letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i") ||
            letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")){
                it.remove();
            }
        }

        System.out.println(letras);
    }

    public static void Ejercicio13(){
        System.out.println("\n ---------- EJERCICIO 13 ----------\n");
        ArrayList<ArrayList<Integer>> listas = new ArrayList<>();
        ArrayList<Integer> listaNumeros1 = new ArrayList<>(
                Arrays.asList(1,2,3)
        );
        ArrayList<Integer> listaNumeros2 = new ArrayList<>(
                Arrays.asList(4,5,6)
        );
        ArrayList<Integer> listaNumeros3 = new ArrayList<>(
                Arrays.asList(7,8,9)
        );

        listas.add(listaNumeros1);
        listas.add(listaNumeros2);
        listas.add(listaNumeros3);

        int total = 0;

        for(var i = 0; i < listas.size(); i++){
            var list = listas.get(i);
            for(var j =0; j< list.size(); j++){
                System.out.println(list.get(j));
                total += list.get(j);
            }
        }

        System.out.println("\n- La suma total es: " + total);
    }

    public static void Ejercicio14() {
        System.out.println("\n ---------- EJERCICIO 14 ----------");

        Map<String, ArrayList<Integer>> promedio = new HashMap<>();

        ArrayList<Integer> grupo1 = new ArrayList<>(
                Arrays.asList(10, 20, 30, 40, 50)
        );

        ArrayList<Integer> grupo2 = new ArrayList<>(
                Arrays.asList(15, 25, 35, 45, 55)
        );

        ArrayList<Integer> grupo3 = new ArrayList<>(
                Arrays.asList(5, 10, 15, 20, 25)
        );

        promedio.put("Huracanes", grupo1);
        promedio.put("Piratas", grupo2);
        promedio.put("Toros", grupo3);


        for(Map.Entry<String, ArrayList<Integer>> entrada : promedio.entrySet()){

            int suma = 0;
            String nombreGrupo = entrada.getKey();
            ArrayList<Integer> listaNumeros = entrada.getValue();

            for(var i = 0; i < listaNumeros.size(); i++){
                suma += listaNumeros.get(i);
            }

            double promedioPorGrupo = (double)suma/listaNumeros.size();

            System.out.printf("- Grupo : %-15s\n- Promedio : %.1f\n------------------------------\n", nombreGrupo, promedioPorGrupo);
        }
    }

    public static void Ejercicio15() {

        System.out.println("\n ---------- EJERCICIO 15 ----------");

        Map<String, ArrayList<Double>> calificacionEstudiantes = new HashMap<>();

        ArrayList<Double> estudiante1 = new ArrayList<>(
                Arrays.asList(8.5, 9.0, 7.5, 8.0)
        );

        ArrayList<Double> estudiante2 = new ArrayList<>(
                Arrays.asList(6.0, 5.5, 7.0, 6.5)
        );

        ArrayList<Double> estudiante3 = new ArrayList<>(
                Arrays.asList(9.5, 9.8, 9.2, 9.7)
        );

        calificacionEstudiantes.put("Ana", estudiante1);
        calificacionEstudiantes.put("Luis", estudiante2);
        calificacionEstudiantes.put("María", estudiante3);

        // Nombre y Promedio
        Map<String, Double> promedios = new HashMap<>();


        for(Map.Entry<String, ArrayList<Double>> entrada : calificacionEstudiantes.entrySet()){

            double suma = 0;
            String nombreEstudiante = entrada.getKey();

            ArrayList<Double> calificaciones = entrada.getValue();

            for(var i= 0; i< calificaciones.size(); i++){
                suma += calificaciones.get(i);
            }

            var promedio = suma / calificaciones.size();

            promedios.put(nombreEstudiante, promedio);
        }

        String nombreDelEstudianteConMayorPromedio = "";
        double mayorProm = -1.0;

        // PROMEDIOS
        for (Map.Entry<String, Double> entrada : promedios.entrySet()){

            var nombreActual = entrada.getKey();
            var promActual = entrada.getValue();

            if(promActual > mayorProm){
                nombreDelEstudianteConMayorPromedio = nombreActual;
                mayorProm = promActual;
            }
        }

        System.out.println("\n----- Mayor promedio -----\n");
        System.out.printf("%-15s : %s\n%-15s : %.2f\n",
                "- Nombre", nombreDelEstudianteConMayorPromedio,
                "- Promedio", mayorProm,
                "--------------------------------------------\n"

        );

        System.out.println("\n----- Estudiantes Aprobados -----\n");

        Iterator<Map.Entry<String, Double>> it = promedios.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Double> entrada = it.next();
            if(entrada.getValue() < 7.0){
                it.remove();
            }else{
                System.out.printf("%-15s : %s\n%-15s : %.2f\n%s",
                        "- Nombre", entrada.getKey(),
                        "- Promedio", entrada.getValue(),
                        "-----------------------------------\n\n"
                        );
            }
        }
    }

    public static void main(String[] args) {
        Ejercicio1();
        Ejercicio2();
        Ejercicio3();
        Ejercicio4();
        Ejercicio5();
        Ejercicio6();
        Ejercicio7();
        Ejercicio8();
        Ejercicio9();
        Ejercicio10();
        Ejercicio11();
        Ejercicio12();
        Ejercicio13();
        Ejercicio14();
        Ejercicio15();
    }

}
