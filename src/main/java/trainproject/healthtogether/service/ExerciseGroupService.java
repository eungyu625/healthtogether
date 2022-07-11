package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
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
    }

    public void removeExerciseGroup(ExerciseGroup exerciseGroup) {

        exerciseGroupRepository.delete(exerciseGroup);
    }

    public void withdrawalMember(ExerciseGroup exerciseGroup, User user) {

        exerciseGroup.withdrawalMember(user);
    }

    public List<ExerciseGroup> findAll() {
        return exerciseGroupRepository.findAll();
    }

    public ExerciseGroup findOne(Long id) {
        return exerciseGroupRepository.getById(id);
    }

    public List<User> findMemberList(ExerciseGroup exerciseGroup) {

        List<User> memberList = new ArrayList<>();

        for (UserGroup userGroup : exerciseGroup.getUserGroupList()) {
            memberList.add(userGroup.getUser());
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
