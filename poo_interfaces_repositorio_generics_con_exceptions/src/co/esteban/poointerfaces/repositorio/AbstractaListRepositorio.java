package co.esteban.poointerfaces.repositorio;


import co.esteban.poointerfaces.modelo.BaseEntity;
import co.esteban.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import co.esteban.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import co.esteban.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatoException;

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
    public T porId(Integer id) throws LecturaAccesoDatoException {

        if(id == null || id <= 0){
            throw new LecturaAccesoDatoException("Id inválido debe ser > 0.");
        }

        T resultadoDeBusqueda = null;
        for(T client : dataSource){
            if(client.getId() != null && client.getId().equals(id)){
                resultadoDeBusqueda = client;
                break;
            }
        }

        if(resultadoDeBusqueda == null){
            throw new LecturaAccesoDatoException("No se ha encontrado el Id: " + id);
        }

        return resultadoDeBusqueda;
    }

    @Override
    public void addCliente(T t) throws EscrituraAccesoDatoException{
        if(t == null){
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null.");
        }

        if(this.dataSource.contains(t)){
            throw new RegistroDuplicadoAccesoDatoException("Error el objeto con id "+ t.getId() + " existe en el repositorio.");
        }
        this.dataSource.add(t);
    }



    @Override
    public void deleteCliente(Integer id) throws LecturaAccesoDatoException{
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
