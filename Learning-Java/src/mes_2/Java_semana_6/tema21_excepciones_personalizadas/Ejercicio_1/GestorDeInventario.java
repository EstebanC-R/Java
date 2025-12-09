package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorDeInventario {
    private static List<Inventario> almacen = new ArrayList<>();

    static public void agregarAInventrio(Inventario productoInfo){
        almacen.add(productoInfo);
        System.out.println("¡¡Se agrego correctamente!! " + productoInfo.getProducto());
    }

    static public void mostrarAlmacen(){
        if(almacenVacio()){
            return;
        }

        for(Inventario item : almacen){
            System.out.println(item);
        }
    }

    static public boolean almacenVacio(){
        if(almacen.isEmpty()){
            System.out.println("\n--------------------------------");
            System.out.println("No hay nada en el almacen.");
            System.out.println("--------------------------------");
            return true;
        }

        return false;
    }

    static public void actualizarInfo(Scanner rl){
        if(almacenVacio()){
            return;
        }

        boolean encontrado = false;
        int numero = 0;
        try {
            System.out.println("Cual es el ID de inventario del producto a actualizar: ");
            numero = rl.nextInt();
            Menu.validarNumerosInt(numero);
        }catch (Exception e){
            System.out.println("Mensaje: " + e.getMessage());
            return;
        }
        while (true) {
            for(Inventario item : almacen){
                if(numero == item.getID()){
                    System.out.println(item);

                    System.out.println("Que es lo que quiere actualizar?\n1. Nombre.\n2. Precio.\n3. Cantidad.\n4. Cancelar.\n- Respuesta: ");
                    int respuesta = 0;
                    try{
                        respuesta = rl.nextInt();
                        rl.nextLine();
                    }catch (NumberFormatException e){
                        System.out.println("**ERROR**\nMensaje: " + e.getMessage());
                        return;
                    }

                    switch (respuesta){
                        case 1:
                            String nombreOriginal = item.getProducto();
                            String nombre = "";
                            try{
                                System.out.println("Ingrese el nuevo nombre a poner: ");
                                nombre = rl.nextLine();
                                Menu.validarString(nombre);
                            }catch (Exception e){
                                System.out.println("Mensaje: " + e.getMessage());
                                return;
                            }
                            item.setProducto(nombre);
                            System.out.println("Nombre actualizado de " + nombreOriginal + " a " + item.getProducto());
                            break;
                        case 2:
                            double precioOriginal = item.getPrecio();
                            double precioNuevo = 0;
                            try{
                                System.out.println("Ingrese el núevo precio: ");
                                precioNuevo = rl.nextDouble();
                                Menu.validarNumerosDouble(precioNuevo);
                            } catch (Exception e){
                                System.out.println("Mensaje: " + e.getMessage());
                                return;
                            }
                            item.setPrecio(precioNuevo);
                            System.out.println("Precio actualizado de " + precioOriginal + " a " + item.getPrecio());
                            break;
                        case 3:
                            int cantidadOriginal = item.getCantidad();
                            int cantidadNueva = 0;
                            try{
                                System.out.println("Ingrese la nueva cantidad en inventario: ");
                                cantidadNueva = rl.nextInt();
                                Menu.validarNumerosInt(cantidadNueva);
                            }catch (Exception e){
                                System.out.println("Mensaje: " + e.getMessage());
                                return;
                            }
                            item.setCantidad(cantidadNueva);
                            System.out.println("Cantidad actualizada de " + cantidadOriginal + " a " + item.getPrecio());
                            break;
                        case 4:
                            System.out.println("El proceso ha sido cancelado.");
                            return;
                        default:
                            System.out.println("El valor debe ser del 1 - 4: ");
                            break;
                    }
                    encontrado = true;
                }
                if(!encontrado){
                    System.out.println("No se ha podido encontrar el ID ingresado.");
                    return;
                }
            }
        }

    }

    static public void descontarProductoEnStock(Scanner rl){
        if(almacenVacio()){
            return;
        }
        int idProducto = 0;
        try {
            System.out.println("Cual es el ID de inventario: ");
            idProducto = rl.nextInt();
            rl.nextLine();
            Menu.validarNumerosInt(idProducto);
        }catch (Exception e){
            System.out.println("Mensaje: " + e.getMessage());
            return;
        }
        for(Inventario item : almacen){
            if(idProducto == item.getID()){
                int cantidadADescontar = 0;

                try{
                    System.out.println("Cantidad a decontar: ");
                    cantidadADescontar = rl.nextInt();
                    rl.nextLine();
                    Menu.validarNumerosInt(cantidadADescontar);
                    item.descontarStock(cantidadADescontar);

                    return;
                }catch (StockInsuficienteException e){
                    System.out.println("**ERROR** La cantidad debe ser número entero");
                    return;
                } catch (Exception e){
                    System.out.println("Mensaje: " + e.getMessage());
                    return;
                }
            }

            System.out.println("**ERROR** ID de inventario no encontrado.");
        }
    }
}
