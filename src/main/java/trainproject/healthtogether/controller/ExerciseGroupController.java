package trainproject.healthtogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import trainproject.healthtogether.config.auth.LoginUser;
import trainproject.healthtogether.config.auth.dto.SessionUser;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.AttendDto;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.repository.UserRepository;
import trainproject.healthtogether.repository.apirepository.ExerciseGroupApiRepository;
import trainproject.healthtogether.service.ExerciseGroupService;
import trainproject.healthtogether.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseGroupController {

    private final ExerciseGroupService exerciseGroupService;
    private final ExerciseGroupApiRepository exerciseGroupApiRepository;

    @GetMapping("/groupMain")
    public List<ExerciseGroupDto> showExerciseGroupInfo() {

        return exerciseGroupApiRepository.findExerciseGroupAll();
    }

    @GetMapping("/groupList")
    public List<ExerciseGroupDto> showExerciseGroupListByUser(@AuthenticationPrincipal User user) {

        return exerciseGroupApiRepository.findExerciseGroupListByUser(user);
    }

    @GetMapping("/groupList/{exerciseGroupId}")
    public List<ExerciseGroupDto> showExerciseGroup(@PathVariable("exerciseGroupId") Long exerciseGroupId) {

        return exerciseGroupApiRepository.findExerciseGroup(exerciseGroupId);
    }


    @PostMapping("/createGroup")
    public List<ExerciseGroupDto> createExerciseGroup(@RequestParam("exerciseName") String exerciseName, @RequestParam("video_title") String video_title,
                                                      @RequestParam("video_url") String video_url, @RequestParam("targetDay") String targetDay,
                                                      @RequestParam("count") Long count, @RequestParam("intro") String intro, @AuthenticationPrincipal User user) {

        ExerciseGroup exerciseGroup = new ExerciseGroup();
        exerciseGroup.setExerciseGroup(exerciseName, video_title, video_url, targetDay, count, intro, user);
        exerciseGroupService.setExerciseGroup(exerciseGroup);

        return exerciseGroupApiRepository.findExerciseGroup(exerciseGroup.getId());
    }

    @PostMapping("/joinGroup/{exerciseGroupId}")
    public List<ExerciseGroupDto> joinExerciseGroup(@PathVariable("exerciseGroupId") Long exerciseGroupId, @AuthenticationPrincipal User user) {

        exerciseGroupService.joinExerciseGroup(exerciseGroupService.findOne(exerciseGroupId), user);

        return exerciseGroupApiRepository.findExerciseGroup(exerciseGroupId);
    }

    @PostMapping("/exerciseGroup/{exerciseGroupId}/attend")
    public void attend(@PathVariable("exerciseGroupId") Long exerciseGroupId, @AuthenticationPrincipal User user) {

        exerciseGroupService.findOne(exerciseGroupId).attend(user);
    }

    @GetMapping("/attendanceBook/{exerciseGroupId}")
    public List<AttendDto> showAttendance(@PathVariable("exerciseGroupId") Long exerciseGroupId) {

        return exerciseGroupApiRepository.findAttendByExerciseGroup(exerciseGroupService.findOne(exerciseGroupId));
    }

    @DeleteMapping("/removeGroup/{exerciseGroupId}")
    public void removeExerciseGroup(@PathVariable("exerciseGroupId") Long exerciseGroupId, @AuthenticationPrincipal User user) {

        exerciseGroupService.removeExerciseGroup(exerciseGroupService.findOne(exerciseGroupId));
    }

    @DeleteMapping("/withdrawalGroup/{exerciseGroupId}")
    public void withdrawalGroup(@PathVariable("exerciseGroupId") Long exerciseGroupId, @AuthenticationPrincipal User user) {

        exerciseGroupService.withdrawalMember(exerciseGroupService.findOne(exerciseGroupId), user);
    }
}
