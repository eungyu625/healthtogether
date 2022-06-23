package trainproject.healthtogether.dto;

import lombok.Getter;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ExerciseGroupDto {

    private Long id;

    private String exerciseGroupName;

    private String intro;

    private Long time;

    private LocalDate startDate;

    private String targetDay;

    private String video_name;

    private String video_url;

    private Long groupAttendanceRate;

    private List<UserDto> memberList;

    protected ExerciseGroupDto() {

    }

    public ExerciseGroupDto(Long id, String exerciseGroupName, String intro, Long time, LocalDate startDate, String targetDay, String video_name, String video_url,
                            Long groupAttendanceRate, List<UserGroup> userGroupList) {

    }
}
