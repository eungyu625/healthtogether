package trainproject.healthtogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainproject.healthtogether.domain.group.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Override
    List<Group> findAll();

    @Override
    Optional<Group> findById(Long Long);
}
