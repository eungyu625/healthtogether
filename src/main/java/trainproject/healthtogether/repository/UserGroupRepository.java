package trainproject.healthtogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;

import java.util.List;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

    List<UserGroup> findByExerciseGroup(ExerciseGroup exerciseGroup);

    List<UserGroup> findByUser(User user);
}
