package co.esteban.ejemplos.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EjemplosHashSetAgregar {
    public static void main(String[] args) {

        Set<String> hs = new HashSet<>();

        System.out.println(hs.add("uno"));
        System.out.println(hs.add("dos"));
        System.out.println(hs.add("tres"));
        System.out.println(hs.add("cuatro"));
        System.out.println(hs.add("cinco"));

        System.out.println(hs);

        boolean repetido = hs.add("tres");
        System.out.println("Permite duplicados?: " + repetido);
        System.out.println(hs);

    }
}
