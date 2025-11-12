package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Arrays_HashSet {
    public static void explicacion(){
        // Arrays ---------------------------------------------->

        System.out.println(" -------------------- Arrays ----------------------------");

        // Declaración e inicialización
        int[] numeros = new int[5];  // Array de 5 enteros (todos en 0)- 5 espacios
        String[] nombres = {"Ana", "Luis", "Pedro"};  // Array con valores

        System.out.println("Listas de números: " + Arrays.toString(numeros));
        System.out.println("Lista tipo String: " + Arrays.toString(nombres));

        // Acceso y modificación
        numeros[0] = 10;  // Asignar valor en posición 0
        int valor = numeros[0];  // Obtener valor = 10 porque se asignó a la posición 0
        int longitud = numeros.length;  // Obtener tamaño


        System.out.println("Cambio de valor posición 0 a tener valor 10: " + Arrays.toString(numeros));
        System.out.println("Nuevo valor para posición 0: " + valor);
        System.out.println("Longitud de la lista números: " + longitud);

        // ArrayList ---------------------------------------------->
        System.out.println("\n ------------------------ ArrayList -------------------------");

        // Se crea la lista con el tipo o referencia que se quiere, después se le da el nombre y se crea.
        ArrayList<String> nombres2 = new ArrayList<>();

        // Agregar elemento
        nombres2.add("Ana");
        nombres2.add("Luis");

        // Diferencia clave entre Array y ArrayList:
        // En los Arrays, hay que convertir la lista a texto con Arrays.toString()
        // porque no tienen un toString() personalizado.

        // En cambio, los ArrayList ya sobrescriben toString(), así que basta con
        // imprimir la variable directamente para ver los valores.
        System.out.println("Posición 1 = Ana y Posición 2 = Luis : " + nombres2);

        // Remover o Eliminar por valor.
        nombres2.remove("Ana");
        System.out.println("Remove Ana solo queda : " + nombres2);

        // Se le asigna una variable y se trae el valor de la posición en el ArrayList
        String primero = nombres2.get(0);  // Obtener por índice
        System.out.println("Ya que Ana se elimino de la posición 0, Luis pasa a ser la 0, por ello es dinámica ArrayList");
        System.out.println("Obtener un valor por posición almacenando en variable : " +  primero);

        // Se crea una variable respecto a lo que nos va a entregar la lista, en este caso es un int
        // debido a que es el tamaño de la lista:
        int tamaño = nombres2.size();  // Obtener tamaño
        System.out.println("Tamaño del ArrayList : " + tamaño);
        System.out.println("Tiene solo 1 debido a que solo esta Luis");

        // Aquí vemos si un valor existe dentro de la lista, para ello creamos una variable
        // boolean y seleccionamos o apuntamos al valor en lista "Luis".
        boolean existe = nombres2.contains("Luis");  // Verificar si existe
        System.out.println("\nVamos a ver si el valor existe dentro del ArrayList : " + existe);

        // HashSet ---------------------------------------------->
        System.out.println("\n ------------------------ HashSet -------------------------");

        // Se crea un HashSet, que funciona como una lista (similar a ArrayList),
        // pero con una diferencia clave: no permite elementos duplicados.

        // Si se intenta agregar un dato que ya existe (según equals y hashCode),
        // simplemente lo ignora.
        HashSet<String> paises = new HashSet<>();


        paises.add("Colombia");
        paises.add("México");
        paises.add("Colombia");  // ❌ No se agrega (ya existe)

        boolean existe2 = paises.contains("México");  // true
        System.out.println("Existe México en la lista : " + existe2);

        int tamaño2 = paises.size();  // 2 (no 3)
        System.out.println("\nEl largo es 2 y no 3 debido a que no agrego el duplicado de Colombia.\nLargo:  " + tamaño2);

        // Removemos México y solo quedaría Colombia.
        paises.remove("México");
        System.out.println("\nLista después de remover México: " + paises);
    }
}
