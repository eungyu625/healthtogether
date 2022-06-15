package trainproject.healthtogether.repository.apirepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.repository.ExerciseGroupRepository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExerciseGroupApiRepository {

    private final EntityManager em;
    private final ExerciseGroupRepository exerciseGroupRepository;

    public List<ExerciseGroupDto> findExerciseGroupList() {

        return em.createQuery("select new trainproject.healthtogether.dto.ExerciseGroupDto(eg.id, eg.exerciseGroupName, eg.targetDay, eg.intro, eg.startDate)" +
                " from ExerciseGroup eg", ExerciseGroupDto.class)
                .getResultList();
    }

}
