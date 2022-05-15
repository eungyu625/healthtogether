package trainproject.healthtogether.dto;

import lombok.Getter;
import trainproject.healthtogether.domain.group.ExerciseGroup;

import java.time.LocalDate;

@Getter
public class ExerciseGroupDto {

    private Long id;

    private String exerciseGroupName;

    private String targetDay;

    private String intro;

    private LocalDate startDate;

    public ExerciseGroupDto(Long id, String exerciseGroupName, String targetDay, String intro, LocalDate startDate) {
        this.id = id;
        this.exerciseGroupName = exerciseGroupName;
        this.targetDay = targetDay;
        this.intro = intro;
        this.startDate = startDate;
    }
}
