package co.esteban.ejemplos.list;

import co.esteban.ejemplos.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> enlazada = new LinkedList<>();
        System.out.println(enlazada + " , size = " + enlazada.size());
        System.out.println("Está vacía? = " + enlazada.isEmpty());


        System.out.println();
        enlazada.add(new Alumno("Mateo", 5.1));
        enlazada.add(new Alumno("Pepe", 4));
        enlazada.add(new Alumno("Yony", 3.1));
        enlazada.add(new Alumno("Yeison", 1.2));
        enlazada.add(new Alumno("Milton", 2.1));
        enlazada.add(new Alumno("Milton2", 2.1));

        System.out.println(enlazada + "\nSize = " + enlazada.size());

        enlazada.addFirst(new Alumno("Kratos", 5));
        enlazada.addLast(new Alumno("Zeus", 2));
        System.out.println(enlazada + "\nSize = " + enlazada.size());

        System.out.println("\nPrimero: " + enlazada.getFirst());
        System.out.println("Ultimo: " + enlazada.getLast());
        System.out.println("Indice 2: " + enlazada.get(2));

        // # Aunque parezcan ser iguales no lo son, ya que el get si está vacío o no tiene datos
        // # lanza una excepción mientras que el peek lo deja como null.
        System.out.println("\nPrimero peek: " + enlazada.peekFirst());
        System.out.println("Ultimo peek: " + enlazada.peekLast());
        System.out.println("Indice 2: " + enlazada.get(2));


        // # Aquí también hay parecidos, ya que estos son lo mismo, pero poll devuelve null si no
        // # encuentra el dato mientras que remove devuelve una excepción.
        // #
        // # También hay que mencionar que directamente cuando se elimina un dato este se puede almacenar
        // # en una instancia como se hace aquí, pero el dato ya no aparece en la lista, ya que lo eliminamos
        // # o sea que el objeto guardado lo podemos utilizar para algo.
        Alumno kratos = enlazada.removeFirst();
        Alumno zeus = enlazada.removeLast();
        //Alumno kratos = enlazada.pollFirst();
        //Alumno zeus = enlazada.pollLast();
        /* Alumno kratos = enlazada.pop(); */ // % ----->  Este es equivalente el removeFirst();
        /* enlazada.remove(1); */ // $ ---> se puede eliminar por indice o por Objeto


        Alumno a = new Alumno("Termo", 2);
        enlazada.addLast(a);
        System.out.println("Indice de Termo = " + enlazada.indexOf(a));


        enlazada.set(6, new Alumno("Olla", 3));
        System.out.println(enlazada + "\nSize = " + enlazada.size());


        // $ Diferencia entre Iterator y ListIterator
        // ! Iterator funciona sobre cualquier colección que implemente Iterable (List, Set, Queue).
        // # Solo permite recorrer hacia adelante con hasNext() y next().
        // ? Permite eliminar elementos con remove(), pero no modificarlos ni insertarlos.
        // % ListIterator funciona únicamente sobre listas (ArrayList, LinkedList).
        // * Permite recorrer hacia adelante y hacia atrás (hasNext/next y hasPrevious/previous).
        // ! Además de remove(), permite modificar con set() e insertar con add().
        // # Expone la posición actual con nextIndex() y previousIndex().
        // $ En resumen: Iterator es más general y simple; ListIterator es más especializado y poderoso para listas.

        ListIterator<Alumno> li = enlazada.listIterator();

        System.out.println("\nhasNext(): ");

        while (li.hasNext()){
            Alumno alumno = li.next();
            System.out.println(alumno);
        }

        System.out.println("\nhasPrevius(): ");

        while(li.hasPrevious()){
            Alumno alumno = li.previous();
            System.out.println(alumno);
        }

    }
}
