package mes_2.Java_semana_5.tema19_generics;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Pila<T> {
    private ArrayList<T> elementos;

    public Pila(){
        this.elementos = new ArrayList<>();
    }

    public void push(T elemento){
        elementos.add(elemento);
    }

    public T pop(){
        if(estaVacia()){
            throw new EmptyStackException();
        }

        int ultimoIndice = elementos.size() - 1;

        return elementos.remove(ultimoIndice);
    }

    public T peek (){
        if(estaVacia()){
            throw new EmptyStackException();
        }

        int ultimoIndice = elementos.size() - 1;

        return elementos.get(ultimoIndice);
    }

    public boolean estaVacia(){
        return elementos.isEmpty();
    }
}
