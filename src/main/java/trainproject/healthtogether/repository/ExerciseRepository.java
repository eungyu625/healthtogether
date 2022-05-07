package trainproject.healthtogether.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainproject.healthtogether.domain.exercise.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    // 운동(루틴) 추가하기

}