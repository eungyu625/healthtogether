package trainproject.healthtogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import trainproject.healthtogether.dto.AttendDto;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.repository.apirepository.ExerciseGroupApiRepository;
import trainproject.healthtogether.service.ExerciseGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void showExerciseGroupList() {

    }

    @PostMapping("/createGroup")
    public void createExerciseGroup() {

    }

    @GetMapping("/attendanceBook/{exerciseGroupId}")
    public List<AttendDto> showAttendance(@PathVariable("exerciseGroupId") Long exerciseGroupId) {

        return exerciseGroupApiRepository.findAttendByExerciseGroup(exerciseGroupService.findOne(exerciseGroupId));
    }
}
