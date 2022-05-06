package trainproject.healthtogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainproject.healthtogether.domain.group.Group;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    Optional<Group> findById(Long aLong);
}
