package mes_2.Java_semana_5.tema17_Colecciones_list_set_map.EjercicioHash_66;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> usuariosValidos = new HashSet<>(
                Arrays.asList("Milton", "Yeison", "Yony", "Mateo")
        );

        List<String> usuariosAVerificar = new ArrayList<>(
                Arrays.asList("Milton", "Gerardo", "Antonio", "Yony")
        );

        for(String usuario : usuariosAVerificar){
            if(usuariosValidos.contains(usuario)){
                System.out.println("El usuario " + usuario + " si esta verificado.");
            }else{
                System.out.println("El usuario " + usuario + " no esta verificado por lo que no es valido.");
            }
        }
    }
}
