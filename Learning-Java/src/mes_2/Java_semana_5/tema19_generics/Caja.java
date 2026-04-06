package mes_2.Java_semana_5.tema19_generics;

public class Caja <T> {
    private T contenido;

    public void guardar (T item){
        this.contenido = item;
    }

    public T obtener(){
        return contenido;
    }
}
