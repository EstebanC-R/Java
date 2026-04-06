import java.util.Scanner;

public class EjemploArreglosBuscarString {
    public static void main(String[] args) {

        String[] a = new String[5];
        Scanner rl = new Scanner(System.in);

        for(int i = 0; i < a.length; i++){
            System.out.print("Ingrese un Nombre: ");
            a[i] = rl.nextLine();
        }

        System.out.println("\nIngrese un Nombre a buscar: ");
        String nombre = rl.next();
        int i = 0;

        for(; i < a.length && !a[i].equalsIgnoreCase(nombre); i++){}

        if(i == a.length){
            System.out.println("Nombre no encontrado");
        }else if(a[i].equalsIgnoreCase(nombre)){
            System.out.println("Encontrado en la posición " + i);
        }
    }
}
