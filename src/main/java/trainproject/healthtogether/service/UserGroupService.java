package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.repository.UserGroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGroupService {

    private final UserGroupRepository userGroupRepository;

    public void save(UserGroup userGroup) {
        userGroupRepository.save(userGroup);
    }

    public List<UserGroup> findUserGroupAll() {
        return userGroupRepository.findAll();
    }

    public List<UserGroup> findUserGroupByExerciseGroup(ExerciseGroup exerciseGroup) {

        return exerciseGroup.getUserGroupList();
    }

    public List<UserGroup> findUserGroupByUser(User user) {

        return user.getUserGroupList();
    }
}
