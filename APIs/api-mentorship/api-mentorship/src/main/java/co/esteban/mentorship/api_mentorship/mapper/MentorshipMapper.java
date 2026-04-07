package co.esteban.mentorship.api_mentorship.mapper;

import co.esteban.mentorship.api_mentorship.dto.MentorshipSessionDTO;
import co.esteban.mentorship.api_mentorship.dto.UserResponseDTO;
import co.esteban.mentorship.api_mentorship.entity.MentorshipSession;
import co.esteban.mentorship.api_mentorship.entity.User;
import org.springframework.stereotype.Component;

@Component
public class MentorshipMapper {

    public MentorshipSessionDTO toDTO (MentorshipSession session){
        return new MentorshipSessionDTO(
                session.getSessionId(),
                session.getSessionDescription(),
                session.getSessionScheduledAt(),
                session.getSessionStatus(),
                toUserResponseDTO(session.getStudent()),
                toUserResponseDTO(session.getMentor())
        );
    }

    public UserResponseDTO toUserResponseDTO (User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setIdUser(user.getIdUser());
        dto.setUserName(user.getUserName());
        dto.setUserRole(user.getUserRole());
        return dto;
    }
}
