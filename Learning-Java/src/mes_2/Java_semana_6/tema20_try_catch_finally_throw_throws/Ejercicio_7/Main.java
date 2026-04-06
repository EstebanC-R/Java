package mes_2.Java_semana_6.tema20_try_catch_finally_throw_throws.Ejercicio_7;

public class Main {

    public static boolean validarContraseña(String password) throws Exception{
        if(password.length() < 6){
            throw new Exception("Contraseña inválida");
        }

        boolean contieneNumero = false;

        for(int i = 0; i < password.length(); i++){
            char caracter = password.charAt(i);

            if(Character.isDigit(caracter)){
                contieneNumero = true;
                break;
            }
        }

        if(!contieneNumero){
            throw new Exception("Contraseña invalida");
        }

        return true;
    }

    public static void main(String[] args) {

        probarValidacion("MiClave123");

        probarValidacion("Corta");

        probarValidacion("SoloLetrasLargas");
    }

    private static void probarValidacion(String clave){
        System.out.println("Probando ´" + clave + "´: ");
        try {
            validarContraseña(clave);
            System.out.println("VALIDA (OK)");
        }catch (Exception e){
            System.err.println("FALLÓ -> Mensaje: " + e.getMessage());
        }
    }
}
