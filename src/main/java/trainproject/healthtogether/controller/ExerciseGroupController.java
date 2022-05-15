package trainproject.healthtogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import trainproject.healthtogether.dto.ExerciseGroupDto;
import trainproject.healthtogether.service.ExerciseGroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExerciseGroupController {

    private final ExerciseGroupService exerciseGroupService;

    @GetMapping("/groupMain")
    public void showGroupInfo() {

    }
}
