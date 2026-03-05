package com.esteban.gestion_tickets.dto;

import com.esteban.gestion_tickets.enums.Priority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TicketCreateDTO {
    @NotBlank(message = "El titulo es obligatorio")
    @Size(min = 5, max = 120, message = "El titulo debe estar entre 5 y 120 caracteres.")
    private String title;

    @NotBlank(message = "La descripción es obligatoria.")
    @Size(min = 10, message = "La descripción debe tener como mínimo 10 caracteres.")
    private String description;

    @NotNull(message = "La prioridad es obligatoria.")
    private Priority priority;

    @NotBlank(message = "El email es obligatorio.")
    @Email
    @Size(max = 254, message = "El número maximo de caracteres es 254.")
    private String assigneeEmail;
}
