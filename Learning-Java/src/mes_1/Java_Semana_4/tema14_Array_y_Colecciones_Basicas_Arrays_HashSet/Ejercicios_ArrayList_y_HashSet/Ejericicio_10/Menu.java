package mes_1.Java_Semana_4.tema14_Array_y_Colecciones_Basicas_Arrays_HashSet.Ejercicios_ArrayList_y_HashSet.Ejericicio_10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Menu {
    public static void menu(Scanner rl, ArrayList<Producto> producto, HashSet<String> codigo, String[] categorias){
        while(true){
            System.out.println("\n------------------- Menú ---------------");
            System.out.println("1. Agregar producto.");
            System.out.println("2. Buscar producto por código.");
            System.out.println("3. Actualizar cantidad de producto.");
            System.out.println("4. Eliminar producto.");
            System.out.println("5. Mostrar productos con stock bajo.");
            System.out.println("6. Mostrar todos los productos.");
            System.out.println("7. Calcular valor total del inventario.");
            System.out.println("8. Salir.");
            System.out.println("Respuesta: ");


            while(!rl.hasNextInt()){
                System.out.println("Por favor seleccione una opción valida 1-8: ");
                rl.next();
            }

            int opcion = rl.nextInt();
            rl.nextLine();

            while(opcion < 1 || opcion > 8){
                System.out.println("Opción fuera de rango, por favor escoja entre el 1 y el 8: ");

                while(!rl.hasNextInt()){
                    System.out.println("Por favor seleccione una opción valida (1-8): ");
                    rl.next();
                }

                opcion = rl.nextInt();
                rl.nextLine();
            }

            switch (opcion){
                case 1:
                    System.out.println("\n------ Agregar Producto ------");
                    System.out.println("- Código: ");
                    String code = rl.nextLine().toLowerCase().trim();
                    System.out.println("- Nombre: ");
                    String nombre = rl.nextLine();

                    System.out.println("Seleccione una Categoria para asignar: ");

                    for(int i = 0; i < categorias.length;i++){
                        System.out.println((i+1)+ " - " + categorias[i]);
                    }

                    while(!rl.hasNextInt()){
                        System.out.println("Seleccione una opción valida (1-5): ");
                        rl.next();
                    }

                    int seleccion = rl.nextInt();
                    rl.nextLine();

                    while(seleccion < 1 || seleccion > categorias.length){
                        System.out.println("Fuera de rango, seleccione otro número: ");

                        while (!rl.hasNextInt()){
                            System.out.println("Por favor seleccione un número valido: ");
                            rl.next();
                        }

                        seleccion = rl.nextInt();
                        rl.nextLine();
                    }

                    String categoriaSeleccionada = categorias[seleccion - 1];

                    System.out.println("- Precio: ");
                    double precio = rl.nextDouble();
                    System.out.println("- Cantidad: ");
                    int cantidad = rl.nextInt();
                    rl.nextLine();


                    if(codigo.contains(code)){
                        System.out.println("- Este código de producto ya está creado.");
                        break;
                    }else{
                        Producto product = new Producto(code, nombre, precio, cantidad, categoriaSeleccionada);
                        producto.add(product);
                        codigo.add(code);
                        System.out.println("---- Producto agregado éxitosamente ----");
                    }
                    break;
                case 2:
                    System.out.println("------ Buscar producto por Código ------");
                    System.out.println("Buscar: ");
                    code = rl.nextLine();

                    boolean encontrado = false;
                    for(Producto p : producto){
                        if(p.getCodigo().equalsIgnoreCase(code)){
                            System.out.println("\n-- Producto encontrado --");
                            System.out.println(p);
                            encontrado = true;
                            break;
                        }
                    }

                    if(!encontrado){
                        System.out.println("- El producto no esta registrado.");
                        break;
                    }

                    break;
                case 3:
                    System.out.println("------- Actualizar cantidad producto -------");
                    System.out.println("- Ingrese el código del producto a actualizar: ");
                    code = rl.nextLine();

                    boolean actualizarBusqueda = false;

                    for(Producto p: producto){
                        if(p.getCodigo().equalsIgnoreCase(code)){
                            int cantidadAnterior = p.getCantidad();
                            System.out.println("Cantidad anterior: " + cantidadAnterior);
                            System.out.println("Cantidad Nueva: ");
                            cantidad = rl.nextInt();
                            p.setCantidad(cantidad);
                            rl.nextLine();
                            System.out.println("Cantidad Actualizada con éxito. :)");
                            actualizarBusqueda = true;
                            break;
                        }
                    }

                    if(!actualizarBusqueda){
                        System.out.println("Lo siento pero este producto no existe en la base. :(");
                        break;
                    }
                    break;
                case 4:
                    System.out.println("\n------ Eliminar Producto ------");
                    System.out.println("- Ingresa el código del producto: ");
                    code = rl.nextLine();

                    encontrado = false;

                    for(Producto p: producto){
                        if(p.getCodigo().equalsIgnoreCase(code)){
                            System.out.println(p);
                            System.out.println();
                            producto.remove(p);
                            System.out.println("Producto eliminado con éxito.");
                            encontrado = true;
                            break;
                        }
                    }

                    if(!encontrado){
                        System.out.println("Producto con código erróneo o no existente.");
                        break;
                    }

                    break;
                case 5:
                    System.out.println("\n----- Mostrar Productos con Bajo Stock -----");
                    boolean hayStockBajo = false;

                    for(Producto p: producto){
                        if(p.getCantidad() < 5){
                            System.out.println(p);
                            hayStockBajo = true;
                        }
                    }

                    if(!hayStockBajo){
                        System.out.println("No hay stock bajo en el momento :) :P.");
                        break;
                    }
                    break;
                case 6:
                    System.out.println("\n------ Mostrar Todos los Productos ------");
                    if(producto.isEmpty()){
                        System.out.println("No hay productos para mostrar.");
                        break;
                    }else{
                        for(Producto p : producto){
                            System.out.println(p);
                        }
                    }
                    break;
                case 7:
                    System.out.println("\n----- Calcular el valor total del inventario ------");

                    double suma = 0;
                    if(producto.isEmpty()){
                        System.out.println("No hay productos para hacer el calculo.");
                        break;
                    }else{
                        for(Producto p: producto){
                            suma += (p.getPrecio() * p.getCantidad());
                        }
                    }

                    System.out.println("- Valor Total de Inventario: " + suma + "$");
                    break;
                case 8:
                    System.out.println("Gracias por utilizar nuestro servicio :) :P :3 (^_^)");
                    rl.close();
                    return;
            }
        }
    }
}
