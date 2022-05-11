package trainproject.healthtogether.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.Role;
import trainproject.healthtogether.domain.user.User;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class ExerciseGroupTest {

    @Autowired
    private ExerciseGroupService exerciseGroupService;

    @Test
    void 그룹생성() {
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        User user = new User("name", "email", "picture", Role.USER);
        exerciseGroup.setExerciseGroup("group", "hello", user, "friday");
        exerciseGroupService.setExerciseGroup(exerciseGroup);

        System.out.println("exerciseGroup : " + exerciseGroup);
        System.out.println("findGroup : " + exerciseGroupService.findAll());
    }
}
