package co.esteban.mentorship.api_mentorship.dto;

import co.esteban.mentorship.api_mentorship.entity.User;
import co.esteban.mentorship.api_mentorship.enums.SessionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MentorshipSessionDTO {
    private Long sessionID;
    private String sessionDescription;
    private LocalDateTime sessionScheduledAt;
    private SessionStatus sessionStatus;
    private UserResponseDTO student;
    private UserResponseDTO mentor;
}