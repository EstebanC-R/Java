package com.esteban.gestion_tickets.repository;

import com.esteban.gestion_tickets.entity.Ticket;
import com.esteban.gestion_tickets.enums.Priority;
import com.esteban.gestion_tickets.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // * encontrar por title
    List<Ticket> findByTitle(String title);

    // ? encontrar por status
    List<Ticket> findByStatus(Status status);

    // $ encontrar por priority
    List<Ticket> findByPriority(Priority priority);

    // % encontrar por email
    List<Ticket> findByAssigneeEmail(String email);


}
