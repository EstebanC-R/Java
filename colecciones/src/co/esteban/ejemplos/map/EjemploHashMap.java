package co.esteban.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {

        Map<String, Object> persona = new HashMap<>();
        System.out.println("\ncontiene elementos = " + !persona.isEmpty() + "\n");

        // # No se puede repetir la clave, pero el valor si, en caso de repetición
        // # este solo pone el último valor repetido.

        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("número", "120");

        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);


        String nombre = (String) persona.get("nombre");
        System.out.println("\nnombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);


        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String estado = direccionPersona.get("estado");
        String barrio = direccionPersona.getOrDefault("barrio", "La playa");

        System.out.println("El país de " + nombre + " es : " + pais);
        System.out.println("La ciudad de " + nombre + " es : " + nombre);
        System.out.println("El estado de " + nombre + " es : " + estado);
        System.out.println("El barrio de " + nombre + " es : " + barrio + "\n");



        String valorApellido = (String) persona.remove("apellidoPaterno");
        /* boolean b = persona.remove("apellidoPaterno", "Doe"); */ // * ---> Cuando es Clave Valor es boolean y devuelve
        // * true o false dependiendo de si la clave y valor si existen en verdad.
        System.out.println("Eliminado = " + valorApellido);
        System.out.println(persona);

        boolean b2 = persona.containsKey("apellidoPaterno");
        System.out.println("b2 = " + b2);
        
        b2 = persona.containsValue("john.doe@email.com");
        System.out.println("b2 = " + b2);


        System.out.println("\n ======================== valores con values() ========================");
        Collection<Object> valores = persona.values();
        for(Object v: valores){
            System.out.println("valores = " + v);
        }

        System.out.println("\n ======================== llaves con keySet() ========================");
        Set<String> llaves = persona.keySet();
        for(String k : llaves){
            System.out.println("llaves = " + k);
        }

        System.out.println("\n ======================== Ambos valores con entrySet() ========================");
        for(Map.Entry<String, Object> par : persona.entrySet()){
            Object valor = par.getValue();
            if(valor instanceof Map){
                String nombrePersona = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                for(Map.Entry<String, String> d : direccionMap.entrySet()){
                    System.out.println(d.getKey() + " => " + d.getValue() );
                }
            } else {
                System.out.println(par.getKey() + " => " + valor);
            }
        }

        // $ Cuando iteramos un Map con foreach clásico, normalmente lo hacemos sobre el conjunto de llaves (keySet).
        // ? Ejemplo: for (String llave : persona.keySet()) { ... }
        // ! Dentro del ciclo, "llave" es la clave, no el valor.
        // # Para obtener el valor asociado, usamos persona.get(llave).
        // * Entonces: persona.get(llave) devuelve el valor vinculado a esa clave.
        // % En resumen: el foreach te da la llave, y con get(llave) accedes al valor.
        // $ Si quieres iterar directamente sobre pares clave-valor, usa entrySet():
        // ? for (Map.Entry<String, Persona> entry : persona.entrySet()) {
        // ?     String llave = entry.getKey();
        // ?     Persona valor = entry.getValue();
        // ? }


        System.out.println("\n ======================== Ambos valores con keySet() ========================");
        for(String llave : persona.keySet()){
            Object valor = persona.get(llave);
            if(valor instanceof Map){
                String nombrePersona = (String) persona.get("nombre");
                Map<String, String> direccionMap = (Map<String, String>) valor;
                System.out.println("El país de " + nombre + " es: " + direccionMap.get("pais"));
                System.out.println("La ciudad de " + nombrePersona + " es: " + direccionMap.get("ciudad"));
                System.out.println("El estado de " + nombrePersona + " es: " + direccionMap.get("estado"));
            } else {
                System.out.println(llave + " => " + valor);
            }

        }

        System.out.println("\n ======================== Java 8 forEach ========================");
        persona.forEach((llave, valor) -> System.out.println(llave + " => " + valor));

        System.out.println("total: " + persona.size());
        System.out.println("contiene elementos = " + !persona.isEmpty());
        boolean b3 = persona.replace("nombre", "John", "Andrés");
        System.out.println("b3 = " + b3);
        System.out.println("persona = " + persona);
    }
}
