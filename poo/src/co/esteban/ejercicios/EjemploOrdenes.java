package co.esteban.ejercicios;

import java.util.Date;

public class EjemploOrdenes {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Milton", "Castaño");
        OrdenCompra orden = new OrdenCompra("Compra de oficina");
        orden.setCliente(cliente1);
        orden.setFecha(new Date());

        orden.addProducto(new Producto("HP", "Laptop", 4250000));
        orden.addProducto(new Producto("Aser", "PC Torre Ryzen 7", 2500000));
        orden.addProducto(new Producto("LogiTech", "Mouse G5", 230000));
        orden.addProducto(new Producto("MotoSpeed" , "Teclado Switches Red", 150000));

        orden.detalles();


        Cliente cliente2 = new Cliente("Yeison", "Soto");
        OrdenCompra orden2 = new OrdenCompra("Compra de aseo");
        orden2.setCliente(cliente2);
        orden2.setFecha(new Date());

        orden2.addProducto(new Producto("Dent", "Cepillo", 3000));
        orden2.addProducto(new Producto("Imuza", "Mesa", 200000));
        orden2.addProducto(new Producto("Colgate", "Pasta dental", 2300));
        orden2.addProducto(new Producto("Trululu" , "Gomitas", 1500));

        orden2.detalles();



        Cliente cliente3 = new Cliente("Yony", "Castaño");
        OrdenCompra orden3 = new OrdenCompra("Compra de viaje");
        orden3.setCliente(cliente3);
        orden3.setFecha(new Date());

        orden3.addProducto(new Producto("Flota GOLD", "Tiquete B-02", 56000));
        orden3.addProducto(new Producto("CTY", "Tienda de Campaña", 420000));
        orden3.addProducto(new Producto("Hollow", "Enlatados", 100000));
        orden3.addProducto(new Producto("Fire" , "Encendedor", 20000));

        orden3.detalles();
    }
}
