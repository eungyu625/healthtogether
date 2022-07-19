package trainproject.healthtogether.repository.apirepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import trainproject.healthtogether.domain.group.Attend;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserExerciseGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.AttendDto;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.service.ExerciseGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ExerciseGroupApiRepository {

    private final ExerciseGroupService exerciseGroupService;

    public List<ExerciseGroupDto> findExerciseGroupAll() {

        List<ExerciseGroupDto> exerciseGroupDtoList = new ArrayList<>();

        for (ExerciseGroup exerciseGroup : exerciseGroupService.findAll()) {
            exerciseGroupDtoList.add(new ExerciseGroupDto(exerciseGroup.getId(), exerciseGroup.getExerciseGroupName(), exerciseGroup.getIntro(), exerciseGroup.getCount(),
                    exerciseGroup.getStartDate(), exerciseGroup.getTargetDay(), exerciseGroup.getVideo_title(), exerciseGroup.getVideo_url(), exerciseGroup.getGroupAttendRate(), exerciseGroup.getMemberList()));
        }

        return exerciseGroupDtoList;
    }

    public List<ExerciseGroupDto> findExerciseGroup(Long exerciseGroupId) {

        List<ExerciseGroupDto> exerciseGroupDtoList = new ArrayList<>();
        ExerciseGroup exerciseGroup = exerciseGroupService.findOne(exerciseGroupId);
        exerciseGroupDtoList.add(new ExerciseGroupDto(exerciseGroup.getId(), exerciseGroup.getExerciseGroupName(), exerciseGroup.getIntro(), exerciseGroup.getCount(),
                exerciseGroup.getStartDate(), exerciseGroup.getTargetDay(), exerciseGroup.getVideo_title(), exerciseGroup.getVideo_url(), exerciseGroup.getGroupAttendRate(), exerciseGroup.getMemberList()));

        return exerciseGroupDtoList;
    }

    public List<ExerciseGroupDto> findExerciseGroupListByUser(User user) {

        List<ExerciseGroupDto> exerciseGroupDtoList = new ArrayList<>();

        for (UserExerciseGroup userExerciseGroup : user.getUserExerciseGroupList()) {

            ExerciseGroup exerciseGroup = userExerciseGroup.getExerciseGroup();
            exerciseGroupDtoList.add(new ExerciseGroupDto(exerciseGroup.getId(), exerciseGroup.getExerciseGroupName(), exerciseGroup.getIntro(), exerciseGroup.getCount(),
                    exerciseGroup.getStartDate(), exerciseGroup.getTargetDay(), exerciseGroup.getVideo_title(), exerciseGroup.getVideo_url(), exerciseGroup.getGroupAttendRate(), exerciseGroup.getMemberList()));
        }

        return exerciseGroupDtoList;
    }

    public List<AttendDto> findAttendByExerciseGroup(ExerciseGroup exerciseGroup) {

        List<AttendDto> attendList = new ArrayList<>();

        for (Map.Entry<User, Attend> member : exerciseGroup.getAttendList().entrySet()) {
            attendList.add(new AttendDto(member.getKey(), member.getValue().getJoinDate(), member.getValue().attendanceRate()));
        }

        return attendList;
    }
}
