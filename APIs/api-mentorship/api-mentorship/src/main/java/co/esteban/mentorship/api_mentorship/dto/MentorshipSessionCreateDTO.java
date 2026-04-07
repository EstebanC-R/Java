package co.esteban.mentorship.api_mentorship.dto;

import co.esteban.mentorship.api_mentorship.entity.User;
import co.esteban.mentorship.api_mentorship.enums.SessionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MentorshipSessionCreateDTO {
    @NotBlank(message = "La descripción es obligatoria.")
    @Size(max = 300, message = "El maximo de caracteres es de 300.")
    private String sessionDescription;

    @NotNull
    private LocalDateTime sessionScheduledAt;

    @NotNull(message = "El estatus es obligatorio.")
    private SessionStatus sessionStatus;

    @NotNull(message = "El ID del estudiante es obligatorio.")
    private Long studentId;

    @NotNull(message = "El ID del mentor es obligatorio.")
    private Long mentorId;
}
