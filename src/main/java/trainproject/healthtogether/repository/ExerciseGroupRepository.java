package trainproject.healthtogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainproject.healthtogether.domain.group.ExerciseGroup;

public interface ExerciseGroupRepository extends JpaRepository<ExerciseGroup, Long> {

}
