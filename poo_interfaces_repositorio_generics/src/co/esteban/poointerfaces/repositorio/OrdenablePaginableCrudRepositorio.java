package co.esteban.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepositorio<T> extends CrudRepositorio<T>,
        PaginableRepositorio<T>, OrdenableRepositorio<T>, ContableRepositorio{

}
