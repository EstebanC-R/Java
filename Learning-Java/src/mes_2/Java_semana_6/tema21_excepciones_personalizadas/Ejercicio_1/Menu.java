package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_1;

import java.util.Scanner;

public class Menu {
    public static void menu(Scanner rl) {
        while(true){
            System.out.println("\n------------------ Menu ------------------");
            String respuesta = "";
            int opcion = 0;
            try{
                System.out.println("- 1. Registrar nuevo producto en inventario.\n- 2. Mostrar Inventario.\n- 3. Actualizar stock.\n- 4. Gastar Stock.\n- 5. Salir.\n- Respuesta: ");
                respuesta = rl.nextLine();
                opcion = Integer.parseInt(respuesta);
            }catch (NumberFormatException e){
                System.out.println("**ERROR**\nMensaje: " + e.getMessage());
            }
            switch (opcion){
                case 1:
                    String nombre = "";
                    double precio = 0;
                    int cantidad = 0;
                    System.out.println("---------------------- Registro ----------------------");
                    try{
                        System.out.println("Ingrese el nombre del producto: ");
                        nombre = rl.nextLine();
                        validarString(nombre);

                        System.out.println("Ingrese el precio: ");
                        precio = rl.nextDouble();
                        validarNumerosDouble(precio);

                        System.out.println("Ingrese la cantidad: ");
                        cantidad = rl.nextInt();
                        validarNumerosInt(cantidad);
                        registrarInventario(nombre, precio, cantidad);

                    }catch (Exception e){
                        System.out.println("**ERROR**\n- Mensaje: " + e.getMessage());
                    }finally {
                        System.out.println("Operación terminada");
                    }
                    break;
                case 2:
                    mostrarAlmacen();
                    break;
                case 3:
                    GestorDeInventario.actualizarInfo(rl);
                    break;
                case 4:
                    GestorDeInventario.descontarProductoEnStock(rl);
                    break;
                case 5:
                    rl.close();
                    System.out.println("Hasta luego.");
                    return;
                default:
                    System.out.println("Debes escoger una opción entre el 1 y el 5.");
                    break;
            }
        }
    }

    static public void registrarInventario(String producto, double precio, int cantidad){
        Inventario nuevoInve = new Inventario(producto, precio, cantidad);
        GestorDeInventario.agregarAInventrio(nuevoInve);
    }

    static public void mostrarAlmacen(){
        GestorDeInventario.mostrarAlmacen();
    }

    static public void validarString(String producto) throws Exception{
        if(producto.trim().isEmpty()){
            throw new Exception("El nombre del producto no puede estar vacío.");
        }
    }

    static public void validarNumerosDouble(double precio)throws Exception{
        if(precio <= 0){
            throw new NumberFormatException("**ERROR** El precio debe ser mayor a 0.");
        }
    }

    static public void validarNumerosInt(int cantidad)throws Exception{
        if(cantidad < 0){
            throw new NumberFormatException("El valor debe ser mayor a 0.");
        }
    }
}
