package co.esteban.api.stream.ejemplos;

import co.esteban.api.stream.ejemplos.models.Factura;
import co.esteban.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("Milton", "Castaño");
        Usuario usuario2 = new Usuario("Yony", "Castaño");

        usuario1.addFactura(new Factura("compras tecnología"));
        usuario1.addFactura(new Factura("compras muebles"));

        usuario2.addFactura(new Factura("bicicleta"));
        usuario2.addFactura(new Factura("notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(usuario1, usuario2);


        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : Cliente ")
                        .concat(f.getUsuario().toString())));

        /*usuarios.stream()
                .map(Usuario::getFacturas)
                .flatMap(List::stream)
                .forEach(f -> System.out.println(f.getDescripcion().concat(" : Cliente ")
                        .concat(f.getUsuario().toString())));*/

        /*for(Usuario u : usuarios){
            for(Factura f : u.getFacturas()){
                System.out.println("- Factura:" + f.getDescripcion());
            }
        }*/

    }
}
