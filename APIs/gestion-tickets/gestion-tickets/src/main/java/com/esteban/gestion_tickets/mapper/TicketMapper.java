package com.esteban.gestion_tickets.mapper;

import com.esteban.gestion_tickets.dto.TicketDTO;
import com.esteban.gestion_tickets.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketDTO toDTO(Ticket dto){
        return new TicketDTO(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getStatus(),
                dto.getPriority(),
                dto.getAssigneeEmail()
        );
    }
}
