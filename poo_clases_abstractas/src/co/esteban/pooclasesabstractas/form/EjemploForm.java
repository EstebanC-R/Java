package co.esteban.pooclasesabstractas.form;

import co.esteban.pooclasesabstractas.form.elementos.*;
import co.esteban.pooclasesabstractas.form.elementos.select.Opcion;
import co.esteban.pooclasesabstractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador()).addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador()).addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new RequeridoValidador()).addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("Lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion ninguna = new Opcion("0", "Ninguna");
        lenguaje.addOpcion(ninguna.setSelected())
                .addOpcion(new Opcion("1", "Java"))
                .addOpcion(new Opcion("2", "JavaScript"))
                .addOpcion(new Opcion("3", "TypeScript"))
                .addOpcion(new Opcion("4", "PHP"))
                .addOpcion(new Opcion("5", "Python"));


        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name ='" + this.nombre + "' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola que tal este campo está deshabilitado!");
        username.setValor("Milton Esteban");
        password.setValor("1256");
        email.setValor("johnDoe@correo.com");
        edad.setValor("21");
        experiencia.setValor("... más de 10 años de experiencia. ...");
        //ninguna.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(
                username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar
        );

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if(!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });
    }
}
