package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.repository.ExerciseGroupRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExerciseGroupService {

    private final ExerciseGroupRepository exerciseGroupRepository;

    public void setExerciseGroup(ExerciseGroup exerciseGroup) {

        exerciseGroupRepository.save(exerciseGroup);
    }

    public void joinExerciseGroup(ExerciseGroup exerciseGroup, User user) {

        exerciseGroup.joinExerciseGroup(user);
        exerciseGroupRepository.save(exerciseGroup);
    }

    public List<ExerciseGroup> findAll() {
        return exerciseGroupRepository.findAll();
    }

    public ExerciseGroup findOne(Long id) {
        return exerciseGroupRepository.getById(id);
    }
}
