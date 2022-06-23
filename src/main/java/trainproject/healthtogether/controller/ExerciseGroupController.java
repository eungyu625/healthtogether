package trainproject.healthtogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.AttendDto;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.repository.apirepository.ExerciseGroupApiRepository;
import trainproject.healthtogether.service.ExerciseGroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseGroupController {

    private final ExerciseGroupService exerciseGroupService;
    private final ExerciseGroupApiRepository exerciseGroupApiRepository;

    @GetMapping("/groupMain")
    public List<ExerciseGroupDto> showExerciseGroupInfo() {

        return exerciseGroupApiRepository.findExerciseGroupList();
    }

    @GetMapping("/groupList")
    public List<ExerciseGroupDto> showExerciseGroupListByUser(@AuthenticationPrincipal User user) {

        return exerciseGroupApiRepository.findExerciseGroupListByUser(user);
    }

    /*
    @PostMapping("/createGroup")
    public List<ExerciseGroupDto> createExerciseGroup(@RequestParam("exerciseName") String exerciseName, @RequestParam("intro") String intro,
                                    @RequestParam("targetDay") String targetDay, @RequestParam("routineTime") int routineTime, @AuthenticationPrincipal User user) {

        ExerciseGroup exerciseGroup = new ExerciseGroup();
        exerciseGroup.setExerciseGroup(exerciseName, intro, user, targetDay);
        exerciseGroupService.setExerciseGroup(exerciseGroup);

        return exerciseGroupApiRepository.findExerciseGroup(exerciseGroup.getId());
    }
     */

    @PostMapping("/joinGroup/{exerciseGroupId}")
    public List<ExerciseGroupDto> joinExerciseGroup(@PathVariable("exerciseGroupId") Long exerciseGroupId, @AuthenticationPrincipal User user) {

        exerciseGroupService.joinExerciseGroup(exerciseGroupService.findOne(exerciseGroupId), user);

        return exerciseGroupApiRepository.findExerciseGroup(exerciseGroupId);
    }

    @GetMapping("/attendanceBook/{exerciseGroupId}")
    public List<AttendDto> showAttendance(@PathVariable("exerciseGroupId") Long exerciseGroupId) {

        return exerciseGroupApiRepository.findAttendByExerciseGroup(exerciseGroupService.findOne(exerciseGroupId));
    }
}
