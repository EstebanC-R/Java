package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_11;

import java.util.*;

public class Main {
    public static void registrarUsuario(String nombre, int edad, String correo) throws Exception{
        validarNombre(nombre);
        validarEdad(edad);
        validarEmail(correo);

        InfoCorreo registro = new InfoCorreo(nombre, edad, correo);
        System.out.println("Registro Exitoso, Bienvenid@ " + registro.getNombre() + "\nRecuerde que su correo es: " + registro.getCorreo());
    }

    public static void validarNombre(String nombre) throws Exception{
        if(nombre == null || nombre.trim().isEmpty()){
            throw new Exception("ERROR. El nombre no puede estar vacío.");
        }
    }

    public static void validarEdad(int edad) throws Exception{
        if(edad < 10){
            throw new Exception("La edad no puede ser menor a 10.");
        }
    }

    public static void validarEmail(String email)throws Exception{int largoEmail = email.length();
        if(!(email.contains("@")) || !(email.contains("gmail.com"))){
            throw new Exception("**ERROR** El correo debe contener ´@´ junto la extensión ´gmail.com´");
        }
    }

    public static void main(String[] args) {
        Scanner rl = new Scanner(System.in);
        String nombre = "";
        int edad = 0;
        String email = "";
        try {
            System.out.println("Ingrese su nombre: ");
            nombre = rl.nextLine();

            System.out.println("Ingrese su edad: ");
            if(rl.hasNextInt()){
                edad = rl.nextInt();
                rl.nextLine();
            }else{
                rl.next();
                throw new Exception("**ERROR** La edad debe ser número entero.");
            }

            System.out.println("Ingrese su correo: ");
            email = rl.nextLine();
            registrarUsuario(nombre, edad, email);

        } catch (Exception e){
            System.out.println("**ERROR DE REGISTRO**");
            System.out.println("Mensaje: " + e.getMessage());
        }finally {
            System.out.println("¡Ha terminado el proceso!");
        }
    }
}
