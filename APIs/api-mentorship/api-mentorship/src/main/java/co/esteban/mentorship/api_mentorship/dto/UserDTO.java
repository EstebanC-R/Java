package co.esteban.mentorship.api_mentorship.dto;

import co.esteban.mentorship.api_mentorship.entity.MentorshipSession;
import co.esteban.mentorship.api_mentorship.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Long idUser;
    private String userName;
    private String userEmail;
    private UserRole userRole;
    private List<MentorshipSessionDTO> mentorshipSessionDTOS;
}
