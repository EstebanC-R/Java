package com.esteban.gestion_tickets.dto;

import com.esteban.gestion_tickets.enums.Priority;
import com.esteban.gestion_tickets.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private String assigneeEmail;
}
