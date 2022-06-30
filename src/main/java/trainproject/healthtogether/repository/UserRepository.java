package trainproject.healthtogether.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import trainproject.healthtogether.domain.user.User;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
