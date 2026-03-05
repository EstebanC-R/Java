package com.esteban.gestion_tickets.service;

import com.esteban.gestion_tickets.dto.TicketCreateDTO;
import com.esteban.gestion_tickets.dto.TicketDTO;
import com.esteban.gestion_tickets.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    /*public TicketDTO create(TicketCreateDTO dto){



    }*/
}
