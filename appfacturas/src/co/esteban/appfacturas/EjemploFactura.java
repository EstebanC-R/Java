package co.esteban.appfacturas;

import co.esteban.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNit("33422-1");
        cliente.setNombre("Esteban");

        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese la descripción de la factura: ");

        Factura factura = new Factura(rl.nextLine(), cliente);

        Producto producto;

        System.out.println();

        for(int i = 0; i < 2; i++){
            producto = new Producto();

            System.out.print("Ingrese producto n " + producto.getCodigo() + ": ");
            producto.setNombre(rl.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(rl.nextDouble());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new ItemFactura(rl.nextInt(), producto));
            System.out.println();
            rl.nextLine();
        }
        System.out.println(factura);
    }
}
