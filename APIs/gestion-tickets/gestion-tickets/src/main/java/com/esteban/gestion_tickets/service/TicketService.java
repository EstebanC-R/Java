package com.esteban.gestion_tickets.service;

import com.esteban.gestion_tickets.dto.StatusUpdateDTO;
import com.esteban.gestion_tickets.dto.TicketCreateDTO;
import com.esteban.gestion_tickets.dto.TicketDTO;
import com.esteban.gestion_tickets.dto.TicketUpdateDTO;
import com.esteban.gestion_tickets.entity.Ticket;
import com.esteban.gestion_tickets.enums.Priority;
import com.esteban.gestion_tickets.enums.Status;
import com.esteban.gestion_tickets.exception.*;
import com.esteban.gestion_tickets.mapper.TicketMapper;
import com.esteban.gestion_tickets.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
    @ @Transactional indica que este método debe ejecutarse dentro de una transacción.

    $ Esto garantiza atomicidad: o todos los cambios se confirman (commit)
    $ o, si ocurre un error, se revierten automáticamente (rollback).

    # En operaciones de escritura (create, update, delete) es fundamental
    # para mantener la consistencia de los datos.

    ! Además, permite que Hibernate aplique "dirty checking":
    ! cualquier entidad modificada dentro de la transacción se actualiza
    ! automáticamente en la base de datos al finalizar el método,
    ! sin necesidad de llamar explícitamente a save().

    * Se recomienda usarlo en métodos que:
    *  - Modifican datos (INSERT, UPDATE, DELETE)
    *  - Ejecutan múltiples operaciones que deben ser atómicas
    *  - Requieren coherencia en lectura y escritura dentro del mismo flujo
 */



@Service
public class TicketService {


    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    // ----------------------- POST create -----------------------

    @Transactional
    public TicketDTO create(TicketCreateDTO dto){

        Ticket ticket = new Ticket();

        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setPriority(dto.getPriority());
        ticket.setAssigneeEmail(dto.getAssigneeEmail().toLowerCase().trim());


        Ticket saved = ticketRepository.save(ticket);

        return ticketMapper.toDTO(saved);
    }


    // ----------------------- getById -----------------------

    public TicketDTO getById(Long id){
        return ticketRepository.findById(id).map(ticketMapper::toDTO).orElseThrow(() -> new TicketNotFoundException("No se encontró el ticket con ID: " + id));
    }


    // ----------------------- getAll -----------------------

    public List<TicketDTO> getAll(){
        List<Ticket> resultado = ticketRepository.findAll();

        if(resultado.isEmpty()){
            throw new TicketNotFoundException("No se han encontrado tickets.");
        }

        return resultado.stream().map(ticketMapper::toDTO).toList();
    }


    // ----------------------- getByTitle -----------------------

    public List<TicketDTO> getByTitleContainsIgnoreCase(String title){
        List<Ticket> resultado = ticketRepository.findByTitleContainsIgnoreCase(title.toLowerCase());

        if(resultado.isEmpty()){
            throw new TitleNotFoundException("No se ha encontrado un titulo relacionado a \"" + title + "\".");
        }

        return resultado.stream().map(ticketMapper::toDTO).toList();
    }


    // ----------------------- getByStatus -----------------------

    public List<TicketDTO> getByStatus(Status status){
        List<Ticket> resultado = ticketRepository.findByStatus(status).stream().toList();

        if(resultado.isEmpty()){
            throw new StatusNotFoundException("No se ha encontrado el Status: " + status);
        }

        return resultado.stream().map(ticketMapper::toDTO).toList();
    }


    // ----------------------- getByPriority -----------------------

    public List<TicketDTO> getByPriority(Priority priority){
        List<Ticket> resultado = ticketRepository.findByPriority(priority).stream().toList();

        if(resultado.isEmpty()){
            throw new PrioriryNotFoundException("No se ha encontrado la Priority: " + priority);
        }

        return resultado.stream().map(ticketMapper::toDTO).toList();
    }


    // ----------------------- getByAssigneeEmail -----------------------
    public List<TicketDTO> getByAssigneeEmail(String email){

        List<Ticket> resultado = ticketRepository.findByAssigneeEmailContainsIgnoreCase(email.toLowerCase().trim());

        if(resultado.isEmpty()){
            throw new EmailNotFoundException("No se ha encontrado el Email: " + email);
        }

        return resultado.stream().map(ticketMapper::toDTO).toList();
    }


    // ----------------------- patch un solo dato, = Actualizar un solo dato. -----------------------


    /*
        % El estado del ticket está tipado como Enum para garantizar que solo se puedan
        % usar valores válidos definidos por el negocio.

        # Si alguien intenta enviar un valor como "CANCELED" y este no existe en el Enum,
        # la aplicación fallará antes de llegar a la base de datos. Esto es intencional:
        # estamos validando primero en la capa de aplicación.

        ! Además, la base de datos también tiene una constraint CHECK que valida los
        ! estados permitidos. Esto actúa como una segunda línea de defensa.

        $ En otras palabras:
        #   - El Enum protege la lógica de negocio.
        #   - La BD protege la integridad de los datos.

        * Esta doble validación no es redundante, es arquitectura defensiva.
        * Así evitamos datos inválidos incluso si en el futuro alguien modifica el código
        * y olvida actualizar una validación.

        @ Regla clave: los datos críticos siempre deben protegerse en más de una capa.
     */

    @Transactional
    public TicketDTO updateStatus(Long id, StatusUpdateDTO dto){

        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("No se encontró el ticket con id: " + id));

        Status estadoActual = ticket.getStatus();
        Status nuevoStatus = dto.getStatus();

        /*
            ! Usamos ordinal() para obtener la posición del estado dentro del enum.

            # En Java, cada valor de un enum tiene un índice interno según el orden
            # en que fue declarado:

            $ OPEN (0) → IN_PROGRESS (1) → RESOLVED (2) → CLOSED (3)

            $ Ese número representa el flujo natural del ticket.

            % Si el nuevo estado tiene un ordinal menor que el actual,
            % significa que se está intentando retroceder en el flujo,
            % lo cual no está permitido.

            @ Nota importante: ordinal() depende del orden del enum.
            @ Si el orden cambia, esta lógica también cambia.
        */


        if (estadoActual == Status.CLOSED) {
            throw new IllegalStateException("No se puede modificar un ticket cerrado.");
        }

        if (nuevoStatus.ordinal() < estadoActual.ordinal()) {
            throw new IllegalArgumentException(
                    "No se puede retroceder el estado del ticket."
            );
        }

        ticket.setStatus(nuevoStatus);

        // # ticket.setUpdatedAt(OffsetDateTime.now());  --> No es necesario por el @PreUpdate que dispara automáticamente cuando
        ticketRepository.save(ticket); // # Se hace esto.

        return ticketMapper.toDTO(ticket);
    }


    // ----------------------- Update -----------------------
    @Transactional
    public TicketDTO update(Long id, TicketUpdateDTO dto){
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException("No se encontró el ticket con id: " + id));

        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setPriority(dto.getPriority());
        ticket.setAssigneeEmail(dto.getAssigneeEmail().toLowerCase());

        return ticketMapper.toDTO(ticket);
    }



    // ----------------------- Delete -----------------------
    @Transactional
    public void deleteById(Long id){
        if(!ticketRepository.existsById(id)){
            throw new TicketNotFoundException("No se ha encontrado el ticket con id " + id);
        }

        ticketRepository.deleteById(id);
    }



}
