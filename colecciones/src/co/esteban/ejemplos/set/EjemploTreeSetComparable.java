package co.esteban.ejemplos.set;

import co.esteban.ejemplos.modelo.Alumno;

import java.util.Set;
import java.util.TreeSet;
import static java.util.Comparator.comparing;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {

        // $ Si el compareTo dependiendo del nombre o la nota, son iguales
        // $ este lo omite, por ejemplo dos Mateos con nota 1, pues solo deja un mateo
        // $ si fuese con nota sería igual, deja solo una nota
        //Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNota().compareTo(a.getNota()));

        Set<Alumno> sa = new TreeSet<>(comparing(Alumno::getNota).reversed());


        sa.add(new Alumno("Milton", 2.1));
        sa.add(new Alumno("Pepe", 4));
        sa.add(new Alumno("Yony", 3.1));
        sa.add(new Alumno("Yeison", 1.2));
        sa.add(new Alumno("Mateo", 2.3));
        sa.add(new Alumno("Javier", 2.2));

        System.out.println("sa = " + sa);
    }
}
