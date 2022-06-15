package trainproject.healthtogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.repository.apirepository.ExerciseGroupApiRepository;
import trainproject.healthtogether.service.ExerciseGroupService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ExerciseGroupController {

    private final ExerciseGroupService exerciseGroupService;
    private final ExerciseGroupApiRepository exerciseGroupApiRepository;

    @GetMapping("/groupMain")
    public List<ExerciseGroupDto> showGroupInfo() {

        return exerciseGroupApiRepository.findExerciseGroupList().stream().collect(Collectors.toList());
    }
}
