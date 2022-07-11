package trainproject.healthtogether.dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.service.ExerciseGroupService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ExerciseGroupDto {

    private Long id;

    private String exerciseGroupName;

    private String intro;

    private Long count;

    private LocalDate startDate;

    private String targetDay;

    private String video_title;

    private String video_url;

    private Long groupAttendanceRate;

    private List<UserDto> memberList;

    protected ExerciseGroupDto() {

    }

    public ExerciseGroupDto(Long id, String exerciseGroupName, String intro, Long count, LocalDate startDate, String targetDay, String video_title, String video_url,
                            Long groupAttendanceRate) {
        this.id = id;
        this.exerciseGroupName = exerciseGroupName;
        this.intro = intro;
        this.count = count;
        this.startDate = startDate;
        this.targetDay = targetDay;
        this.video_title = video_title;
        this.video_url = video_url;
        this.groupAttendanceRate = groupAttendanceRate;
    }
}
