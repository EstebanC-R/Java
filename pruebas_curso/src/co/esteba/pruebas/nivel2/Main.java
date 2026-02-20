package co.esteba.pruebas.nivel2;

import co.esteba.pruebas.nivel2.models.Cliente;
import co.esteba.pruebas.nivel2.models.Producto;
import co.esteba.pruebas.nivel2.repositories.RepositorioCliente;
import co.esteba.pruebas.nivel2.repositories.RepositorioProducto;

import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        RepositorioCliente repositorioCliente = new RepositorioCliente();
        RepositorioProducto repositorioProducto = new RepositorioProducto();

        Cliente cliente1 = new Cliente(1, "Milton", "milton@gmail.com", LocalDate.of(2026, 1, 23));
        Cliente cliente2 = new Cliente(1, "Yony", "yony@gmail.com", LocalDate.of(2026, 2, 3));
        Cliente cliente3 = new Cliente(2, "Mateo", "mateo@gmail.com", LocalDate.of(2026, 2, 3));
        Cliente cliente4 = new Cliente(3, "Daniel", "daniel@gmail.com", LocalDate.of(2026, 2, 13));
        Cliente cliente5 = new Cliente(4, "Yeison", "yeison@gmail.com", LocalDate.of(2023, 5, 16));
        Cliente cliente6 = new Cliente(5, "Toquica", "toquica@gmail.com", LocalDate.of(2026, 4, 19));


        Producto producto1 = new Producto(1, "Arroz Diana", 2500, "Carbohidratos", 125);
        Producto producto2 = new Producto(1, "Espagueti penne", 3500, "Carbohidratos", 46);
        Producto producto3 = new Producto(2, "Salsa Roja", 1500, "Azucares", 30);
        Producto producto4 = new Producto(3, "Computador Pc Ryzen 5", 2500000, "Tecnología", 4);
        Producto producto5 = new Producto(4, "Gatorade", 4600, "Bebidas", 200);
        Producto producto6 = new Producto(5, "Amper", 3000, "bebidas", 40);
        Producto producto7 = new Producto(6, "Sal", 2000, "sodio", 21);
        Producto producto8 = new Producto(7, "Azúcar", 3000, "azucares", 11);

        repositorioCliente.agregar(cliente1);
        repositorioCliente.agregar(cliente2);
        repositorioCliente.agregar(cliente3);
        repositorioCliente.agregar(cliente4);
        repositorioCliente.agregar(cliente5);
        repositorioCliente.agregar(cliente6);

        repositorioProducto.agregar(producto1);
        repositorioProducto.agregar(producto2);
        repositorioProducto.agregar(producto3);
        repositorioProducto.agregar(producto4);
        repositorioProducto.agregar(producto5);
        repositorioProducto.agregar(producto6);
        repositorioProducto.agregar(producto7);
        repositorioProducto.agregar(producto8);

        // ! ---------------------------------- Prueba de métodos de producto ----------------------------------

        System.out.println("\n------- Listar Todos los Productos --------");
        repositorioProducto.listarTodos().forEach(System.out::println);

        System.out.println("\n------- Conteo de Productos --------");
        System.out.println("Total productos: " + repositorioProducto.contar());

        System.out.println("\n------- Buscar por ID Productos --------");
        int id = 1;
        System.out.println(repositorioProducto.buscarPorId(id).orElseThrow(() -> new NullPointerException("No existe este ID " + id)));

        System.out.println("\n------- Eliminar por ID Productos --------");
        // ? Eliminó 2 ya que ambos tenían el ID = 1, pero se puede cambiar por otro para verlo más evidente.
        repositorioProducto.eliminar(id);
        repositorioProducto.listarTodos().forEach(System.out::println);

        System.out.println("\n------- Buscar por Categoría Productos --------");
        repositorioProducto.buscarPorCategoria("azucares").forEach(System.out::println);

        System.out.println("\n------- Buscar por rango de precio --------");
        repositorioProducto.buscarPorRangoPrecio(200, 300).forEach(System.out::println);

        System.out.println("\n------- Buscar producto más caro --------");
        System.out.println(repositorioProducto.productoMasCaro().orElseThrow(() -> new NullPointerException("No hay productos para mostrar.")));

        System.out.println("\n------- Calcular valor de inventario --------");
        System.out.printf("Valor total de inventario: %.0f\n", repositorioProducto.calcularValorInventario());

        System.out.println("\n------- Lista ordenada productos --------");
        repositorioProducto.ordenarPor(Comparator.comparing(Producto::getNombre)).forEach(System.out::println);


        // ! ---------------------------------- Prueba de métodos de cliente ----------------------------------

        System.out.println("\n------- Listar Todos los Clientes --------");
        repositorioCliente.listarTodos().forEach(System.out::println);

        System.out.println("\n------- Conteo de Clientes --------");
        System.out.println("Total de clientes: " + repositorioCliente.contar());

        System.out.println("\n------- Buscar por ID Cliente --------");
        int idCliente = 1;
        System.out.println(repositorioCliente.buscarPorId(idCliente).orElseThrow(() -> new NullPointerException("No existe este ID " + id)));

        System.out.println("\n------- Eliminar por ID Cliente --------");
        // ? Eliminó 2 ya que ambos tenían el ID = 1, pero se puede cambiar por otro para verlo más evidente.
        repositorioCliente.eliminar(idCliente);
        repositorioCliente.listarTodos().forEach(System.out::println);

        System.out.println("\n------- Registros en mes y año - Clientes --------");
        repositorioCliente.registradosEnMes(2, 2026).forEach(System.out::println);

        System.out.println("\n------- Contar Clientes Nuevos --------");
        System.out.println(repositorioCliente.contarClientesNuevos(LocalDate.of(2025, 11, 29)));

        System.out.println("\n------- Lista ordenada clientes --------");
        repositorioCliente.ordenarPor(Comparator.comparing(Cliente::getEmail)).forEach(System.out::println);

    }
}
