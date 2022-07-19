package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserExerciseGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.repository.ExerciseGroupRepository;

import java.util.ArrayList;
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

    public void removeExerciseGroup(ExerciseGroup exerciseGroup) {

        for (UserExerciseGroup userExerciseGroup : exerciseGroup.getUserExerciseGroupList()) {
            userExerciseGroup.getUser().removeUserExerciseGroupList(exerciseGroup);
        }
        exerciseGroupRepository.delete(exerciseGroup);
    }

    public void withdrawalMember(ExerciseGroup exerciseGroup, User user) {

        exerciseGroup.withdrawalMember(user);
        exerciseGroupRepository.save(exerciseGroup);
    }

    public void attend(ExerciseGroup exerciseGroup, User user) {
        exerciseGroup.attend(user);
        exerciseGroupRepository.save(exerciseGroup);
    }

    public List<ExerciseGroup> findAll() {
        return exerciseGroupRepository.findAll();
    }

    public List<ExerciseGroup> findExerciseGroupByUser(User user) {
        List<ExerciseGroup> exerciseGroupList = new ArrayList<>();

        for (UserExerciseGroup userExerciseGroup : user.getUserExerciseGroupList()) {
            exerciseGroupList.add(userExerciseGroup.getExerciseGroup());
        }

        return exerciseGroupList;
    }

    public ExerciseGroup findOne(Long id) {
        return exerciseGroupRepository.getById(id);
    }

    public List<User> findMemberList(ExerciseGroup exerciseGroup) {

        List<User> memberList = new ArrayList<>();

        for (UserExerciseGroup userExerciseGroup : exerciseGroup.getUserExerciseGroupList()) {
            memberList.add(userExerciseGroup.getUser());
        }

        return memberList;
    }

    public Long getGroupAttendanceRate(ExerciseGroup exerciseGroup) {

        return exerciseGroup.getGroupAttendRate();
    }

    public Integer getMemberAttendanceRate(ExerciseGroup exerciseGroup, User user) {

        return exerciseGroup.memberAttendRate(user);
    }
}
