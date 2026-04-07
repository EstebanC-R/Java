package co.esteban.mentorship.api_mentorship.repository;

import co.esteban.mentorship.api_mentorship.entity.MentorshipSession;
import co.esteban.mentorship.api_mentorship.enums.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorshipRepository extends JpaRepository<MentorshipSession, Long> {
    List<MentorshipSession> findByStudentId(Long studentId);
    List<MentorshipSession> findByMentorId(Long mentorId);
    List<MentorshipSession> findByMentorIdAndStatus(Long mentorId, SessionStatus status);

}
