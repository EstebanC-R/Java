package co.esteban.ejemplos.set;

import co.esteban.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        Set<Alumno> sa = new HashSet<>();
        //List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Mateo", 5.1));
        sa.add(new Alumno("Pepe", 4));
        sa.add(new Alumno("Yony", 3.1));
        sa.add(new Alumno("Yeison", 1.2));
        sa.add(new Alumno("Milton", 2.1));
        sa.add(new Alumno("Milton2", 2.1));
        sa.add(new Alumno("Antonio", 4.1));
        sa.add(new Alumno("Antonio", 6.1));

        System.out.println("sa = " + sa);

        System.out.println("\n- Utilizando un for clásico (Solo para tipo List<T>): ");
        /*for(int i = 0; i < sa.size(); i++){
            Alumno a = sa.get(i);
            System.out.println(a);
        }*/

        System.out.println("\n- Iterando usando un for: ");
        for(Alumno a: sa){
            System.out.println(a);
        }

        System.out.println("\n- Iterando usando while y iterator: ");

        Iterator<Alumno> it = sa.iterator();

        while(it.hasNext()){
            Alumno a = it.next();
            System.out.println(a);
        }
        System.out.println("\n- Iterando Con forEach: ");
        sa.forEach(System.out::println);
    }
}
