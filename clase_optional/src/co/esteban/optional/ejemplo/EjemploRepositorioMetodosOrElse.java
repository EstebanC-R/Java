package co.esteban.optional.ejemplo;

import co.esteban.optional.ejemplo.models.Celular;
import co.esteban.optional.ejemplo.models.Computador;
import co.esteban.optional.ejemplo.repositorio.CelularRepositorio;
import co.esteban.optional.ejemplo.repositorio.ComputadorRepositorio;
import co.esteban.optional.ejemplo.repositorio.Repositorio;

import java.util.List;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("HP Omnen", "LA0001");
        // # La diferencia clave entre orElse y orElseGet es que orElse asi sea que
        // # encuentre el resultado este va a llamar al método y va a ocupar espacio
        // # ya que si creó la instancia con los valores por defecto, mientras que el orElseGet
        // # no se invoca. orElseGet es mucho mejor o más seguro por asi decirlo.
        Computador pc = repositorio.filtrarPorNombre("Rog").orElse(valorDefecto());
        System.out.println(pc);


        pc = repositorio.filtrarPorNombre("macbook").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
        System.out.println(pc);
    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto!!");
        return new Computador("Asus Unknow", "40222");
    }
}
