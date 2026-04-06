package com.esteban.gestion_tickets.dto;

import com.esteban.gestion_tickets.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusUpdateDTO {
    private Status status;
}
