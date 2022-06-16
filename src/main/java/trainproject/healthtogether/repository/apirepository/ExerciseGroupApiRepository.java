package trainproject.healthtogether.repository.apirepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.repository.ExerciseGroupRepository;
import trainproject.healthtogether.service.ExerciseGroupService;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ExerciseGroupApiRepository {

    private final EntityManager em;
    private final ExerciseGroupRepository exerciseGroupRepository;
    private final ExerciseGroupService exerciseGroupService;

    public List<ExerciseGroupDto> findExerciseGroupList() {

        return em.createQuery("select new trainproject.healthtogether.dto.ExerciseGroupDto(eg.id, eg.exerciseGroupName, eg.intro, eg.routineTime, eg.startDate, eg.targetDay, eg.userGroupList)" +
                " from ExerciseGroup eg", ExerciseGroupDto.class)
                .getResultList();
    }

    public List<ExerciseGroupDto> findExerciseGroupListByUser(User user) {

        List<ExerciseGroup> exerciseGroupList = new ArrayList<>();

        for (UserGroup userGroup : user.getUserGroupList()) {

            exerciseGroupList.add(userGroup.getExerciseGroup());
        }


        List<ExerciseGroupDto> result = new ArrayList<>();

        for (ExerciseGroup exerciseGroup : exerciseGroupList) {
            result.add(new ExerciseGroupDto(exerciseGroup.getId(), exerciseGroup.getExerciseGroupName(), exerciseGroup.getIntro(), exerciseGroup.getRoutineTime(), exerciseGroup.getStartDate(), exerciseGroup.getTargetDay(), exerciseGroup.getUserGroupList()));
        }

        return result;
    }

}
