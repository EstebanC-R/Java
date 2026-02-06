package co.esteban.java8.lambda;

import co.esteban.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test = num -> num > 10;
        boolean r = test.test(11);
        System.out.println("r = " + r);

        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(test2.test("ROLE_ADMIN"));


        BiPredicate<String, String> test3 = String::equals; // * (a, b) -> a.equals(b);
        System.out.println(test3.test("Milton", "Milton"));

        BiPredicate<Integer, Integer> test4 = (i, j) -> j > i;
        boolean r2 = test4.test(2, 4);
        System.out.println(r2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("Yeison");
        b.setNombre("Mateo");
        BiPredicate<Usuario, Usuario> test5 = (uA, uB) -> uA.getNombre().equals(uB.getNombre());
        System.out.println(test5.test(a, b));

    }
}
