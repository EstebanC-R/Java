package co.esteban.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {

    public static void main(String[] args) {

        String nombre = "Andres";

        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println("opt.isPresent() = " + opt.isPresent()); // # Devuelve un true

        // $ Es mejor utilizar el .get() con un if que valide el isPresent()
        if (opt.isPresent()) {
            System.out.println("Hola " + opt.get());
        }

        System.out.println("opt.isEmpty() = " + opt.isEmpty()); // # lo contrario de isPresent()


        opt.ifPresent( valor -> System.out.println("Hola " + valor));

        nombre = "John";
        // % Se tiene que evitar siempre un null ya que no lo soporta
        // % Con el Optional.of() pero si en cambio lo pones con el Optional.ofNullable este si lo soporta

        System.out.println();
        opt = Optional.ofNullable(nombre);
        System.out.println("opt = " + opt);
        System.out.println("opt.isPresent() = " + opt.isPresent());
        System.out.println("opt.isEmpty() = " + opt.isEmpty());
        opt.ifPresentOrElse( v -> System.out.println("Hola " + v), () -> System.out.println("No está presente"));

        if(opt.isPresent()){
            System.out.println("Hola " + opt.get());
        } else {
            System.out.println("No está presente");
        }

        Optional<String> optEmpty = Optional.empty();
        System.out.println("optEmpty = " + optEmpty);
        System.out.println(optEmpty.isPresent());
    }
}
