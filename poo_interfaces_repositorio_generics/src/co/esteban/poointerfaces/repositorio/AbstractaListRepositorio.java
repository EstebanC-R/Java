package co.esteban.poointerfaces.repositorio;


import co.esteban.poointerfaces.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {

    protected List<T> dataSource;

    public AbstractaListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) {
        T resultadoDeBusqueda = null;
        for(T client : dataSource){
            if(client.getId() != null && client.getId().equals(id)){
                resultadoDeBusqueda = client;
                break;
            }
        }

        return resultadoDeBusqueda;
    }

    @Override
    public void addCliente(T t) {
        this.dataSource.add(t);
    }



    @Override
    public void deleteCliente(Integer id) {
        this.dataSource.remove(this.porId(id));
    }


    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
