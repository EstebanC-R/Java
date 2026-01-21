package co.esteban.poointerfaces.repositorio;

import co.esteban.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio<Cliente> {

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultadoDeBusqueda = null;
        for(Cliente client : dataSource){
            if(client.getId() != null && client.getId().equals(id)){
                resultadoDeBusqueda = client;
                break;
            }
        }

        return resultadoDeBusqueda;
    }

    @Override
    public void addCliente(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void deleteCliente(Integer id) {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {

        List<Cliente> listaOrdenada = new ArrayList<>(dataSource);

        listaOrdenada.sort((a, b) -> {
                int resultado = 0;
                if(dir ==  Direccion.ASC){
                    resultado = ordenar(campo, a, b);
                } else if(dir == Direccion.DESC){
                    resultado = ordenar(campo, b, a);
                }
                return resultado;
            });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
