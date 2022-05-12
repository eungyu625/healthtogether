package trainproject.healthtogether.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.Role;
import trainproject.healthtogether.domain.user.User;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class ExerciseGroupServiceTest {

    @Autowired
    private ExerciseGroupService exerciseGroupService;

    @Test
    void 그룹생성() {
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        User user = new User("name", "email", "picture", Role.USER);
        exerciseGroup.setExerciseGroup("group", "hello", user, "friday");
        exerciseGroupService.setExerciseGroup(exerciseGroup);
    }

    @Test
    void 그룹가입() {
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        User user = new User("name", "email", "picture", Role.USER);
        exerciseGroup.setExerciseGroup("group", "hello", user, "friday");
        exerciseGroupService.setExerciseGroup(exerciseGroup);
        User user1 = new User("name1", "email1", "picture1", Role.USER);
        ExerciseGroup findGroup = exerciseGroupService.findOne(1L);
        findGroup.joinExerciseGroup(user1);
        findGroup.attend(user1);

        System.out.println("memberList : " + exerciseGroup.getMemberList());
    }
}
