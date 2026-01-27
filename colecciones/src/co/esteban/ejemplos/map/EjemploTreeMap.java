package co.esteban.ejemplos.map;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {


        // % en TreeMap no pueden existir en las llaves null, ya que esto desembocará en un NullPointerException
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());

        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@email.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "One Street");
        direccion.put("número", "120");

        persona.put("direccion", direccion);
        System.out.println("persona => " + persona);

    }
}
