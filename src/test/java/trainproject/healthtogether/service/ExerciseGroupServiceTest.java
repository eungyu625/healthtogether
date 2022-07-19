package trainproject.healthtogether.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.Role;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.repository.apirepository.ExerciseGroupApiRepository;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class ExerciseGroupServiceTest {

    @Autowired
    private ExerciseGroupService exerciseGroupService;

    @Autowired
    private ExerciseGroupApiRepository exerciseGroupApiRepository;


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

    @Test
    void 가입한_그룹_리스트() {
        User user = User.builder()
                .email("email")
                .name("name")
                .picture("picture")
                .role(Role.USER)
                .build();
        ExerciseGroup exerciseGroup1 = new ExerciseGroup();
        exerciseGroup1.setExerciseGroup("exerciseGroup1", "video_title1", "video_url1", "Friday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup1);
        ExerciseGroup exerciseGroup2 = new ExerciseGroup();
        exerciseGroup2.setExerciseGroup("exerciseGroup2", "video_title2", "video_url2", "Thursday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup2);

        User member = User.builder()
                .email("abc")
                .name("name1")
                .picture("picture")
                .role(Role.USER)
                .build();
        ExerciseGroup findGroup1 = exerciseGroupService.findOne(exerciseGroup1.getId());
        exerciseGroupService.joinExerciseGroup(findGroup1, member);
        exerciseGroupService.joinExerciseGroup(exerciseGroupService.findOne(exerciseGroup2.getId()), member);

        System.out.println("exerciseGroupService : " + exerciseGroupService.findExerciseGroupByUser(member));
        System.out.println(exerciseGroupApiRepository.findExerciseGroupListByUser(member));
        for (ExerciseGroupDto exerciseGroupDto : exerciseGroupApiRepository.findExerciseGroupListByUser(member)) {
            System.out.println("name : " + exerciseGroupDto.getExerciseGroupName());
        }

        for (ExerciseGroupDto exerciseGroupDto : exerciseGroupApiRepository.findExerciseGroupAll()) {
            System.out.println("all : " + exerciseGroupDto.getExerciseGroupName());
        }
    }

    @Test
    void 그룹탈퇴() {
        User user = User.builder()
                .email("email")
                .name("name")
                .picture("picture")
                .role(Role.USER)
                .build();
        ExerciseGroup exerciseGroup1 = new ExerciseGroup();
        exerciseGroup1.setExerciseGroup("exerciseGroup1", "video_title1", "video_url1", "Friday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup1);
        ExerciseGroup exerciseGroup2 = new ExerciseGroup();
        exerciseGroup2.setExerciseGroup("exerciseGroup2", "video_title2", "video_url2", "Thursday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup2);

        User member = User.builder()
                .email("abc")
                .name("name1")
                .picture("picture")
                .role(Role.USER)
                .build();
        ExerciseGroup findGroup1 = exerciseGroupService.findOne(exerciseGroup1.getId());
        exerciseGroupService.joinExerciseGroup(findGroup1, member);
        exerciseGroupService.joinExerciseGroup(exerciseGroupService.findOne(exerciseGroup2.getId()), member);
        for (ExerciseGroupDto exerciseGroupDto : exerciseGroupApiRepository.findExerciseGroupListByUser(member)) {
            System.out.println("name : " + exerciseGroupDto.getExerciseGroupName());
        }
        exerciseGroupService.withdrawalMember(findGroup1, member);
        System.out.println("-- AFTER --");
        for (ExerciseGroupDto exerciseGroupDto : exerciseGroupApiRepository.findExerciseGroupListByUser(member)) {
            System.out.println("name : " + exerciseGroupDto.getExerciseGroupName());
        }
    }

    @Test
    void 그룹삭제() {
        User user = User.builder()
                .email("email")
                .name("name")
                .picture("picture")
                .role(Role.USER)
                .build();
        ExerciseGroup exerciseGroup1 = new ExerciseGroup();
        exerciseGroup1.setExerciseGroup("exerciseGroup1", "video_title1", "video_url1", "Friday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup1);
        ExerciseGroup exerciseGroup2 = new ExerciseGroup();
        exerciseGroup2.setExerciseGroup("exerciseGroup2", "video_title2", "video_url2", "Thursday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup2);
        for (ExerciseGroupDto exerciseGroupDto : exerciseGroupApiRepository.findExerciseGroupAll()) {
            System.out.println("name : " + exerciseGroupDto.getExerciseGroupName());
        }
        exerciseGroupService.removeExerciseGroup(exerciseGroupService.findOne(exerciseGroup1.getId()));
        System.out.println("-- AFTER --");
        for (ExerciseGroupDto exerciseGroupDto : exerciseGroupApiRepository.findExerciseGroupAll()) {
            System.out.println("name : " + exerciseGroupDto.getExerciseGroupName());
        }
        System.out.println("-- USER --");
        for (ExerciseGroupDto exerciseGroupDto : exerciseGroupApiRepository.findExerciseGroupListByUser(user)) {
            System.out.println("name : " + exerciseGroupDto.getExerciseGroupName());
        }
    }

    @Test
    void 출석() {
        User user = User.builder()
                .email("email")
                .name("name")
                .picture("picture")
                .role(Role.USER)
                .build();
        ExerciseGroup exerciseGroup = new ExerciseGroup();
        exerciseGroup.setExerciseGroup("exerciseGroup", "video_title", "video_url", "Friday", 0L, "intro", user);
        exerciseGroupService.setExerciseGroup(exerciseGroup);

        ExerciseGroup findGroup = exerciseGroupService.findOne(exerciseGroup.getId());
        System.out.println(findGroup.memberAttendRate(user));
        System.out.println("-- AFTER --");
        exerciseGroupService.attend(findGroup, user);
        System.out.println(exerciseGroupService.findOne(findGroup.getId()).memberAttendRate(user));
    }
}
