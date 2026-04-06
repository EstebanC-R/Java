package co.esteban.poointerfaces;

import co.esteban.poointerfaces.modelo.Producto;
import co.esteban.poointerfaces.repositorio.Direccion;
import co.esteban.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import co.esteban.poointerfaces.repositorio.excepciones.AccesoDatoException;
import co.esteban.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import co.esteban.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.addCliente(new Producto("Aguacate", 3000));
            repo.addCliente(new Producto("Manzana", 2000));
            repo.addCliente(new Producto("Pera", 1300));
            repo.addCliente(new Producto("Piña", 4000.00));

            List<Producto> productos = repo.listar();

            productos.forEach(System.out::println);

            System.out.println("\n=========== Paginable ==========");

            List<Producto> paginable = repo.listar(0, 3);
            paginable.forEach(System.out::println);

            System.out.println("\n=========== Ordenar ==========");

            List<Producto> productoOrdenAsc = repo.listar("precio", Direccion.ASC);

            for (Producto p : productoOrdenAsc) {
                System.out.println(p);
            }
            ;

            System.out.println("\n=========== Editar ==========");

            Producto aguacateUpdate = new Producto("Aguacate crema", 4000.01);
            aguacateUpdate.setId(1);

            repo.updateCliente(aguacateUpdate);

            Producto aguacate = repo.porId(1);

            repo.listar("precio", Direccion.DESC).forEach(System.out::println);


            System.out.println("\n=========== Eliminar ==========");


            repo.deleteCliente(2);
            repo.listar().forEach(System.out::println);

            System.out.println("\n=========== Total ==========");
            System.out.println("Total Registros: " + repo.total());
        } catch (LecturaAccesoDatoException e){
            System.out.println("Mensaje: "+ e.getMessage());
            e.printStackTrace(System.out);
        } catch (AccesoDatoException e){
            System.out.println("Mensaje: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
