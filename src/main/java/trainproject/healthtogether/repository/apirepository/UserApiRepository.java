package trainproject.healthtogether.repository.apirepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserExerciseGroup;
import trainproject.healthtogether.dto.UserDto;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserApiRepository {

    private EntityManager em;

    public List<UserDto> findMemberList(ExerciseGroup exerciseGroup) {

        List<UserDto> result = new ArrayList<>();

        for (UserExerciseGroup userExerciseGroup : exerciseGroup.getUserExerciseGroupList()) {
            result.add(new UserDto(userExerciseGroup.getUser().getId(), userExerciseGroup.getUser().getName(), userExerciseGroup.getUser().getEmail(),
                    userExerciseGroup.getUser().getUserExerciseGroupList()));
        }

        return result;
    }

}
