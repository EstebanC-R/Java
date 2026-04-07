package co.esteban.mentorship.api_mentorship.services;

import co.esteban.mentorship.api_mentorship.dto.MentorshipSessionCreateDTO;
import co.esteban.mentorship.api_mentorship.dto.MentorshipSessionDTO;
import co.esteban.mentorship.api_mentorship.dto.UserResponseDTO;
import co.esteban.mentorship.api_mentorship.entity.MentorshipSession;
import co.esteban.mentorship.api_mentorship.entity.User;
import co.esteban.mentorship.api_mentorship.enums.UserRole;
import co.esteban.mentorship.api_mentorship.exception.MentorNotFoundException;
import co.esteban.mentorship.api_mentorship.exception.StudentNotFoundException;
import co.esteban.mentorship.api_mentorship.mapper.MentorshipMapper;
import co.esteban.mentorship.api_mentorship.repository.MentorshipRepository;
import co.esteban.mentorship.api_mentorship.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorshipService {

    private final MentorshipRepository mentorshipRepository;
    private final MentorshipMapper mentorshipMapper;
    private final UserRepository userRepository;

    public MentorshipSessionDTO create(MentorshipSessionCreateDTO dto){
        User student = userRepository.findByIdAndRole(dto.getStudentId(), UserRole.STUDENT).orElseThrow(() -> new StudentNotFoundException("No se ha encontrado al estudiante."));

        User mentor = userRepository.findByIdAndRole(dto.getMentorId(), UserRole.MENTOR).orElseThrow(() -> new MentorNotFoundException("No se ha encontrado al mentor."));

        if(student.getIdUser().equals(mentor.getIdUser())){
            throw new RuntimeException("Un estudiante no puede solicitarse una mentoría a si mismo.");
        }

        MentorshipSession session = new MentorshipSession();
        session.setSessionDescription(dto.getSessionDescription());
        session.setSessionScheduledAt(dto.getSessionScheduledAt());
        session.setSessionStatus(dto.getSessionStatus());
        session.setStudent(student);
        session.setMentor(mentor);

        MentorshipSession save = mentorshipRepository.save(session);

        return mentorshipMapper.toDTO(save);

    }


}
