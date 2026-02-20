package co.esteba.pruebas.nivel2.repositories;

import co.esteba.pruebas.nivel2.models.Cliente;
import co.esteba.pruebas.nivel2.models.RepositorioBase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RepositorioCliente extends RepositorioBase<Cliente> {
    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        return lista.stream().filter(e -> id.equals(e.getId())).findFirst();
    }

    @Override
    public void eliminar(Integer id) {
        lista.removeIf(e -> id.equals(e.getId()));
    }

    public List<Cliente> registradosEnMes(int mes, int anio){
        return lista.stream().filter(e -> e.getFechaRegistro().getMonth().getValue() == mes && e.getFechaRegistro().getYear() == anio).toList();
    }

    public long contarClientesNuevos(LocalDate desde){
        return lista.stream().filter(c -> c.getFechaRegistro().isAfter(desde)).count();
    }

}
