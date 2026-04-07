package co.esteban.mentorship.api_mentorship.dto;

import co.esteban.mentorship.api_mentorship.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long idUser;
    private String userName;
    private UserRole userRole;
}
