package trainproject.healthtogether.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import trainproject.healthtogether.domain.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
