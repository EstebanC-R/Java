package co.esteban.ejemplos.list;

import co.esteban.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class EjemploArrayList {
    public static void main(String[] args) {

        List<Alumno> al = new ArrayList<>();
        System.out.println(al + " , size = " + al.size());
        System.out.println("Está vacía? = " + al.isEmpty());


        System.out.println();
        al.add(new Alumno("Mateo", 5.1));
        al.add(new Alumno("Pepe", 4));
        al.add(new Alumno("Yony", 3.1));
        al.add(new Alumno("Yeison", 1.2));
        al.add(2, new Alumno("Milton", 2.1));
        al.set(3, new Alumno("Milton2", 2.1));

        System.out.println(al + "\nSize = " + al.size());

        al.remove(new Alumno("Mateo", 5.1)); // ? ----> debe ser totalmente igual de lo contrario no lo elimina
        // ? Por lo menos en el ejemplo, ya que este método remove se rige por el equals y el hashCode.

        /* al.remove(1); */ // $ ---> elimina por indice

        System.out.println(al + "\nSize = " + al.size());


        boolean b = al.contains(new Alumno("Pepe", 4));
        System.out.println("\nLa lista contiene a Pepe = " + b);

        // $ antes habíamos añadido a Milton en la posicion 2 por lo que yony se movio a la posicion 3
        // $ este fue reemplazado por Milton2, asi que no existe.
        boolean c = al.contains(new Alumno("Yony", 3.1));
        System.out.println("La lista contiene a Yony = " + c);


        Object a[] = al.toArray();

        for(int i = 0; i < a.length; i++){
            System.out.println("\n- Desde el arreglo = " + a[i]);
        }

    }
}
