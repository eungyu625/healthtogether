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
import trainproject.healthtogether.dto.ExerciseGroupDto;
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
        User user = User.builder()
                .name("name")
                .email("email")
                .picture("picture")
                .role(Role.USER)
                .build();

        ExerciseGroup exerciseGroup = new ExerciseGroup();
        exerciseGroup.setExerciseGroup("exerciseGroup", "video_title", "video_url", "Friday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup);

        assertThat(exerciseGroup.getExerciseGroupName()).isEqualTo(exerciseGroupApiRepository.findExerciseGroup(1L).get(0).getExerciseGroupName());
    }

    @Test
    void 그룹가입() {
        User user = User.builder()
                .email("email")
                .name("name")
                .picture("picture")
                .role(Role.USER)
                .build();

        ExerciseGroup exerciseGroup = new ExerciseGroup();
        exerciseGroup.setExerciseGroup("exerciseGroup", "video_title", "video_url", "Friday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup);

        User member = User.builder()
                .email("abc")
                .name("name1")
                .picture("picture")
                .role(Role.USER)
                .build();

        ExerciseGroup findGroup = exerciseGroupService.findOne(exerciseGroup.getId());
        exerciseGroupService.joinExerciseGroup(findGroup, member);

        for (User mem : exerciseGroup.getMemberList()) {
            System.out.println("name : " + mem.getName());
        }
    }
}
