package mes_2.Java_semana_5.tema19_generics;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Cola<T> {
    private LinkedList<T> elementos;

    public Cola(){
        this.elementos = new LinkedList<>();
    }

    public void encolar(T elemento){
        elementos.addLast(elemento);
    }

    public T desencolar(){
        if(estaVacia()){
            throw new NoSuchElementException("La cola está vacia. No se puede desencolar.");
        }

        return elementos.removeFirst();
    }

    public T verPrimero(){
        if(estaVacia()){
            throw new NoSuchElementException("La cola está vacia. No hay primer elemento.");
        }

        return elementos.getFirst();
    }

    public boolean estaVacia(){
        return elementos.isEmpty();
    }
}
