import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio {
    static ArrayList<String> nombres = new ArrayList<>();
    static void main() {
        Scanner rl = new Scanner(System.in);
        do {
            System.out.println("\n------- Bienvenido al menu -------\n1. Actualizar\n2. Eliminar\n3. Agregar\n4. Listar\n5. Salir\n- Respuesta: ");
            String respuesta = rl.nextLine();
            int respuestaNum = 0;
            try {
                respuestaNum = Integer.parseInt(respuesta);
                validarInt(respuestaNum);
            } catch (Exception e){
                System.out.println("Mensaje: " + e.getMessage());
            }
            switch (respuestaNum){
                case 1:
                    if(listaVacia()){
                        break;
                    }
                    mostrarLista();
                    String nombreOriginal = "";
                    String nombreActualizado = "";
                    try {
                        System.out.println("Ingresa el nombre que quieres actualizar: ");
                        nombreOriginal = rl.nextLine();
                        validarTexto(nombreOriginal);

                        System.out.println("Por cual nombre lo quieres actualizar?: ");
                        nombreActualizado = rl.nextLine();
                        validarTexto(nombreActualizado);
                    }catch (Exception e){
                        System.out.println("Mensaje: " + e.getMessage());
                    }

                    int largoLista = nombres.size();
                    boolean encontrado = false;
                    for(var i = 0; i < largoLista; i++){
                        if(nombres.get(i).equalsIgnoreCase(nombreOriginal)){
                            nombres.set(i, nombreActualizado);
                            encontrado = true;
                            System.out.println("Usuario actualizado correctamente!!");
                            break;
                        }
                    }
                    if(!encontrado){
                        System.out.println("No se ha encontrado el nombre en la lista.");
                    }
                    break;
                case 2:
                    if(listaVacia()){
                        break;
                    }
                    mostrarLista();
                    String nombreAEliminar = "";
                    try {
                        System.out.println("Ingresa el nombre que deseas eliminar: ");
                        nombreAEliminar = rl.nextLine();
                        validarTexto(nombreAEliminar);
                    } catch (Exception e){
                        System.out.println("Mensaje: " + e.getMessage());
                    }
                    if(nombres.contains(nombreAEliminar.trim())){
                        nombres.remove(nombreAEliminar);
                        System.out.println("Usuario eliminado correctamente");
                    }else{
                        System.out.println("Nombre no encontrado.");
                    }
                    break;
                case 3:
                    String nombre = "";
                    try {
                        System.out.println("Ingresa un nombre: ");
                        nombre = rl.nextLine();
                        validarTexto(nombre);
                    }catch (Exception e){
                        System.out.println("Mensaje: " + e.getMessage());
                    }
                    nombres.add(nombre.toLowerCase());
                    break;
                case 4:
                    mostrarLista();
                    break;
                case 5:
                    System.out.println("Haz salido con exito!");
                    rl.close();
                    return;
                default:
                    System.out.println("Escoge una opción del 1 al 5. ");
                    break;
            }
        } while (true);
    }

    public static void validarTexto(String texto) throws Exception{
        if(texto.trim().isEmpty()){
            throw new Exception("**ERROR** Debe haber texto ingresado.");
        }
    }

    public static void validarInt(int numero) throws Exception{
        if(numero < 0){
            throw new Exception("El número debe ser mayor a 0.");
        }
    }

    public static void mostrarLista(){
        if(listaVacia()){
            return;
        }

        int contador = 1;
        for(String item : nombres){
            System.out.println(contador++ + " - " + item);
        }
    }

    public static boolean listaVacia(){
        if(nombres.isEmpty()){
            System.out.println("\n- No hay datos aún en la lista.");
            return true;
        }

        return false;
    }
}
