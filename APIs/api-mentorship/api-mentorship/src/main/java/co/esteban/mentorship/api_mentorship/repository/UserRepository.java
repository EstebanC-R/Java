package co.esteban.mentorship.api_mentorship.repository;

import co.esteban.mentorship.api_mentorship.entity.User;
import co.esteban.mentorship.api_mentorship.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndRole(Long id, UserRole role);

    Optional<User> findByEmail(String email);
}
