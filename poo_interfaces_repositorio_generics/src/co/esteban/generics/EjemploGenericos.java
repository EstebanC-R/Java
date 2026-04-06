package co.esteban.generics;

import co.esteban.poointerfaces.modelo.Cliente;
import co.esteban.poointerfaces.modelo.ClientePremium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        // % Aquí lo único que se está haciendo es básicamente una lista de ArrayList con el parámetro Cliente
        // % llamada clientes. Esto indica que solo puede tener valores de la Clase Cliente.
        // % Después se guarda el primer dato en la instancia de Cliente llamada "primerCliente".
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Milton", "Castaño"));
        Cliente primerCliente = clientes.getFirst();


        // % Convierte un Array en una Lista con tamaño fijo.
        // % La lista resultante permite modificar elementos existentes con .set(indice, nuevoValor),
        // %, pero no admite operaciones de agregar (.add) ni eliminar (.remove),
        // % ya que mantiene el mismo tamaño del arreglo original.
        Cliente[] clientesArreglo = {new Cliente("Milton", "Castaño"), new Cliente("Yeison", "Soto")};
        List<Cliente> clientes2 = fromArrayToList(clientesArreglo);

        System.out.println("\n =============== PRIMERA ITERACIÓN ===============");

        // # ORIGINAL
        clientes2.forEach(System.out::println);

        // # MÉTODO SET PARA CAMBIAR EL PRIMER VALOR ("Milton", "Castaño") a =>
        clientes2.set(0, new Cliente("Yony", "Castaño"));
        System.out.println("\n =============== SEGUNDA ITERACIÓN ===============");

        // # MODIFICACIÓN
        clientes2.forEach(System.out::println);

        // ! _______________________________ LO MISMO QUE LO ANTERIOR PERO CON UN TIPO Integer _____________________________________

        Integer[] enterosArreglo = {1, 2, 3};
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);
        enterosLista.set(0, 4);

        enterosLista.forEach(System.out::println);

        // * _______________________________ PROBANDO SOBRECARGA T[] c - G[] x_____________________________________

        System.out.println("\n =============== SOBRECARGAR DE MÉTODO ===============");

        List<Cliente> sobrecarga = fromArrayToList(clientesArreglo, enterosArreglo);

        sobrecarga.forEach(System.out::println);

        System.out.println("\n =============== SOBRECARGAR DE MÉTODO 2 ===============");

        // % Aquí lo que esta pasando es que como ya no llamamos al método fromArrayToList() con los dos Arreglos[] pues digamos
        // % que lo que quedó de la variable sobrecarga fue el *return* de los clientes, por ello ya no vuelve a llamar a el for.

        sobrecarga.set(0, new Cliente("Mateo", "Anyway"));

        sobrecarga.forEach(System.out::println);


        // $ _______________________________ MÉTODO AL INSTANTE DE INGRESAR DATOS _____________________________________

        System.out.println("\n =============== MÉTODO AL INSTANTE DE INGRESAR DATOS ===============");

        List<String> nombres = fromArrayToList(new String[]{"Pepe", "Antonio", "José"}, new Integer[]{21, 22, 23, 24, 25, 26});
        nombres.forEach(System.out::println);

        // $ _______________________________ GENERICS PERO CON EXTENDS O HEREDACION ESPECIFICA _____________________________________

        System.out.println("\n =============== HEREDACIÓN DE CLASES PADRE ===============");

        List<ClientePremium> clientesPremiumList = fromArrayToList(new ClientePremium[]{new ClientePremium("Manuel", "Atehortua")});
        imprimirClientes(clientesPremiumList);

        System.out.println("\n =============== COMODÍN EN MÉTODOS DE LISTAS <? ===============");

        imprimirClientes(clientes);
        System.out.println("======================");
        imprimirClientes(clientes2);
        System.out.println("======================");
        imprimirClientes(clientesPremiumList);

        System.out.println("\n- Maximo de 8, 3 y 5 es: " + maximo(8, 3, 5));
        System.out.println("\n- Maximo de 2.3, 3.12 y 21.1 es: " + maximo(2.3, 3.12, 21.1));
        System.out.println("\n- Maximo de zanahoria, arándanos y manzana es: " + maximo("zanahoria", "arándanos", "manzana"));


    }


    // # Método genérico: <T> permite usar cualquier tipo de clase (Cliente, Integer, String, etc.).
    // * Recibe un Array (T[]) y lo convierte en una Lista con Arrays.asList.
    // ! Importante: la lista resultante mantiene el tamaño fijo del array original.
    // % Esto significa que solo puedes modificar elementos existentes con .set(indice, valor),
    // ! pero NO puedes agregar (.add) ni eliminar (.remove) elementos,
    // ! porque sigue estando limitada al tamaño del arreglo inicial.
    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T extends Cliente> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x){
        for(G elemento : x){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }


    // ! El comodín <? extends Cliente> indica que la lista puede contener objetos de la clase Cliente
    // % o de cualquier subclase de Cliente. Esto permite mayor flexibilidad al recibir listas,
    // % ya que no importa si son exactamente List<Cliente> o List<ClienteVIP>, List<ClienteEmpresa>, etc.
    // % Sin embargo, al usar <? extends Cliente> solo puedes leer (get) elementos como Cliente,
    // % no puedes agregar nuevos objetos (add), porque el compilador no sabe el tipo exacto de subclase.
    // % En este ejemplo, simplemente se recorre la lista y se imprime cada Cliente.
    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }


    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }

        if(c.compareTo(max) > 0){
            max = c;
        }

        return max;
    }
}
