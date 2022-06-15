package trainproject.healthtogether.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.Role;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.repository.UserGroupRepository;
import trainproject.healthtogether.repository.apirepository.ExerciseGroupApiRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class ExerciseGroupServiceTest {

    @Autowired
    private ExerciseGroupService exerciseGroupService;

    @Autowired
    private ExerciseGroupApiRepository exerciseGroupApiRepository;

    @Autowired
    private UserGroupService userGroupService;

    @Test
    void 그룹생성() {
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        User user = new User("name", "email", "picture", Role.USER);
        exerciseGroup.setExerciseGroup("group", "hello", user, "friday", 1);
        exerciseGroupService.setExerciseGroup(exerciseGroup);
    }

    @Test
    void 그룹가입() {
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        User user = new User("name", "email", "picture", Role.USER);
        exerciseGroup.setExerciseGroup("group", "hello", user, "friday", 1);
        exerciseGroupService.setExerciseGroup(exerciseGroup);
        User user1 = new User("name1", "email1", "picture1", Role.USER);
        ExerciseGroup findGroup = exerciseGroupService.findOne(1L);
        findGroup.joinExerciseGroup(user1);
        findGroup.attend(user1);

        System.out.println("memberList : " + exerciseGroup.getMemberList());
    }

    @Test
    void 참여() {
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        User user = new User("name", "email", "picture", Role.USER);
        exerciseGroup.setExerciseGroup("group", "hello", user, "friday", 1);
        exerciseGroupService.setExerciseGroup(exerciseGroup);
        User user1 = new User("name1", "email1", "picture1", Role.USER);
        ExerciseGroup findGroup = exerciseGroupService.findOne(1L);
        findGroup.joinExerciseGroup(user1);
        findGroup.attend(user1);

        System.out.println("user1's attend : " + findGroup.getMemberList().get(user1).getAttendanceDays());
    }

    @Test
    void UserGroup_테스트() {
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        User user = new User("name", "email", "picture", Role.USER);
        exerciseGroup.setExerciseGroup("group", "hello", user, "friday", 1);
        exerciseGroupService.setExerciseGroup(exerciseGroup);
        UserGroup userGroup = new UserGroup(exerciseGroup, user);
        userGroupService.save(userGroup);

        User user1 = new User("name1", "email1", "picture1", Role.USER);
        ExerciseGroup findGroup = exerciseGroupService.findOne(1L);
        findGroup.joinExerciseGroup(user1);
        findGroup.attend(user1);

        UserGroup userGroup1 = new UserGroup(findGroup, user1);

        userGroupService.save(userGroup1);

        List<User> memberList = new ArrayList<>();

        for (UserGroup member : userGroupService.findUserGroupByExerciseGroup(findGroup)) {
            memberList.add(member.getUser());
        }

        System.out.println(memberList);
        System.out.println("user : " + user + "user1 : " + user1);
    }

}
