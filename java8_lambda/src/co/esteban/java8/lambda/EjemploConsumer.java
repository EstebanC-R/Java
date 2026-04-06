package co.esteban.java8.lambda;

import co.esteban.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {

        // ! ------------------------------------------------------------------------------------------------
        // ! Recibe argumentos
        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sf.format(fecha));
        };

        consumidor.accept(new Date());

        // ? ------------------------------------------------------------------------------------------------

        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre + ", tiene " + edad + " años!!");

        consumidorBi.accept("Pepe", 12);

        // # ------------------------------------------------------------------------------------------------

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        // * ------------------------------------------------------------------------------------------------

        List<String> nombres = Arrays.asList("Andres", "Milton", "Pepe", "Yony");
        nombres.forEach(System.out::println);

        // % ------------------------------------------------------------------------------------------------

        Supplier<Usuario> creaUsuario = Usuario::new;

        Usuario usuario = creaUsuario.get();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;

        asignarNombre.accept(usuario, "Milton");

        System.out.println("Nombre usuario: " + usuario.getNombre());

        // $ ------------------------------------------------------------------------------------------------

        // $ Muy pareceido al Callable<> básicamente devuevlve un resultado
        Supplier<String> proveedor = () ->  "Hola mundo lambda supplier";

        System.out.println(proveedor.get());
    }
}
