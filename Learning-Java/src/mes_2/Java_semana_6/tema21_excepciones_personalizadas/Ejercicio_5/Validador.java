package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_5;

import mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_3.DatosInvalidosException;

public class Validador {

    public static void validadEdad(int edad) throws DatosInvalidosException{
        if(edad < 0){
            throw new DatosInvalidosException("La edad no puede ser menor a 0.");
        }
    }


}
