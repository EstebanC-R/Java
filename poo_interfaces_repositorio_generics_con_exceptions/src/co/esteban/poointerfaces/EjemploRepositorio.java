package co.esteban.poointerfaces;

import co.esteban.poointerfaces.modelo.Cliente;
import co.esteban.poointerfaces.repositorio.*;
import co.esteban.poointerfaces.repositorio.excepciones.AccesoDatoException;
import co.esteban.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import co.esteban.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import co.esteban.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;
import co.esteban.poointerfaces.repositorio.lista.ClieneListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {

            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClieneListRepositorio();
            repo.addCliente(new Cliente("Milton", "Castaño"));
            repo.addCliente(new Cliente("Daniel", "Ramírez"));
            repo.addCliente(new Cliente("Yony", "Castaño"));
            repo.addCliente(new Cliente("Yaneiby", "Castaño"));

            Cliente mateo = new Cliente("Mateo", "X");
            repo.addCliente(mateo);
            repo.addCliente(mateo);

            //repo.addCliente(null);
            List<Cliente> clientes = repo.listar();

            clientes.forEach(System.out::println);

            System.out.println("\n=========== Paginable ==========");

            List<Cliente> paginable = repo.listar(0, 3);
            paginable.forEach(System.out::println);

            System.out.println("\n=========== Ordenar ==========");

            List<Cliente> clientesOrdenAsc = repo.listar("id", Direccion.DESC);

            for (Cliente c : clientesOrdenAsc) {
                System.out.println(c);
            }
            ;

            System.out.println("\n=========== Editar ==========");

            Cliente danielActualizar = new Cliente("Daniel", "Gómez");
            danielActualizar.setId(2);

            repo.updateCliente(danielActualizar);

            Cliente daniel = repo.porId(2);
            System.out.println(daniel);

            repo.listar("nombre", Direccion.DESC).forEach(System.out::println);


            System.out.println("\n=========== Eliminar ==========");


            repo.deleteCliente(1);
            repo.listar().forEach(System.out::println);

            System.out.println("\n=========== Total ==========");
            System.out.println("Total Registros: " + repo.total());
        } catch (LecturaAccesoDatoException e){
            System.out.println("Mensaje Lectura: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (RegistroDuplicadoAccesoDatoException e){
            System.out.println("Mensaje Registro duplicado: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (EscrituraAccesoDatoException e){
            System.out.println("Mensaje Escritura: " + e.getMessage());
            e.printStackTrace(System.out);
        }  catch (AccesoDatoException e){
            System.out.println("Mensaje Generica: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
