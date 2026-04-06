package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_6;

import mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_4.ArgumentoNuloException;

public class Procesador {
    public static void procesarObjeto(Object obj) throws ArgumentoNuloException {
        if(obj == null){
            throw new ArgumentoNuloException();
        }
    }
}
