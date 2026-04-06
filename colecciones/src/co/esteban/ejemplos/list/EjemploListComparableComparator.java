package co.esteban.ejemplos.list;

import co.esteban.ejemplos.modelo.Alumno;

import java.util.*;
import static java.util.Comparator.comparing;

public class EjemploListComparableComparator {
    public static void main(String[] args) {

        List<Alumno> sa = new LinkedList<>();
        sa.add(new Alumno("Mateo", 5.1));
        sa.add(new Alumno("Pepe", 4));
        sa.add(new Alumno("Yony", 3.1));
        sa.add(new Alumno("Yeison", 1.2));
        sa.add(new Alumno("Milton", 2.1));
        sa.add(new Alumno("Milton2", 2.1));
        sa.add(new Alumno("Antonio", 4.1));
        sa.add(new Alumno("Antonio", 6.1));

        //Collections.sort(sa);
        //Collections.sort(sa, (a, b) -> b.getNota().compareTo(a.getNota()));
        //sa.sort((a, b) -> a.getNota().compareTo(b.getNota()));

        //sa.sort(Comparator.comparing((Alumno a) -> a.getNombre()).reversed());
        //sa.sort(Comparator.comparing(Alumno::getNombre).reversed());
        sa.sort(comparing(Alumno::getNombre));

        System.out.println("sa = " + sa);


        System.out.println("\n- Iterando Con forEach: ");
        sa.forEach(System.out::println);


    }
}
