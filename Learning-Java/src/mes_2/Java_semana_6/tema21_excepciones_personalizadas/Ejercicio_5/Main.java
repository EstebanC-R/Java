package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_5;

import mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_3.DatosInvalidosException;

public class Main {
    public static void main(String[] args) {
        int edad = -1;

        try{
            Validador.validadEdad(edad);
        }catch (DatosInvalidosException e){
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}
