package co.esteban.mentorship.api_mentorship.entity;

import co.esteban.mentorship.api_mentorship.enums.SessionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mentorship_sessions")
@Getter
@Setter
public class MentorshipSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;

    @Column(name = "session_description", nullable = false)
    private String sessionDescription;

    @Column(name = "session_scheduled_at", nullable = false)
    private LocalDateTime sessionScheduledAt;

    @Column(name = "session_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private SessionStatus sessionStatus = SessionStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "FK_student_id", nullable = false)
    private User student;

    @ManyToOne
    @JoinColumn(name = "FK_mentor_id", nullable = false)
    private User mentor;
}
