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

    private int routineTime;

    private LocalDate startDate;

    private String targetDay;

    private List<UserDto> memberList;

    protected ExerciseGroupDto() {

    }

    public ExerciseGroupDto(Long id, String exerciseGroupName, String intro, int routineTime, LocalDate startDate, String targetDay, List<UserGroup> userGroupList) {
        this.id = id;
        this.exerciseGroupName = exerciseGroupName;
        this.intro = intro;
        this.routineTime = routineTime;
        this.startDate = startDate;
        this.targetDay = targetDay;

        for (UserGroup userGroup : userGroupList) {
            this.memberList.add(new UserDto(userGroup.getUser().getId(), userGroup.getUser().getName(), userGroup.getUser().getEmail(), userGroup.getUser().getPicture(),
                    userGroup.getUser().getNickName(), userGroup.getUser().getFriendList(), userGroup.getUser().getUserGroupList()));
        }
    }
}
