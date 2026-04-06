import java.util.ArrayList;
import java.util.Scanner;

public class OperadoresLogicosLogin {
    static void main(String[] args) {

        /*String[] usernames = new String[3];
        String[] passwords = new String[3];

        usernames[0] = "Milton";
        passwords[0] = "12345";

        usernames[1] = "admin";
        passwords[1] = "12345";

        usernames[2] = "pepe";
        passwords[2] = "123";*/

        String[] usernames = {"Milton", "admin", "pepe"};
        String[] passwords = {"123","1234", "12345"};

        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese sú usuario: ");
        String nombreUser = rl.nextLine();

        System.out.println("Ingrese su contraseña: ");
        String passwordUser = rl.nextLine();

        boolean esAutenticado = false;

        for(var i = 0; i < usernames.length; i++){
            esAutenticado = usernames[i].equals(nombreUser) && passwords[i].equals(passwordUser) ? true : esAutenticado;

            /*if( usernames[i].equals(nombreUser) && passwords[i].equals(passwordUser)){
                esAutenticado = true;
                break;
            }*/
        }

        String mensaje = esAutenticado ?  "Bienvenido usuario ".concat(nombreUser).concat("!") : "Usuario o contraseña incorrecto!\nLo sentimos, requiere autenticación";
        System.out.println("Mensaje = " + mensaje);

        /*if (esAutenticado) {
            System.out.println("Bienvenido usuario ".concat(nombreUser).concat("!"));
        } else {
            System.out.println("Usuario o contraseña incorrecto!");
            System.out.println("Lo siento, requiere autenticación");
        }*/
    }
}
