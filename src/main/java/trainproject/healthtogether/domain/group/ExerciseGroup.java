package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class ExerciseGroup {

    @Id
    @GeneratedValue
    @Column(name = "exerciseGroup_id")
    private Long id;

    private String exerciseGroupName;

    private String intro;

    private LocalDateTime localDateTime;

    private String targetDay;

    @OneToMany(mappedBy = "exerciseGroup")
    private List<Attend> attendList = new ArrayList<>();

    @OneToMany(mappedBy = "exerciseGroup")
    private List<UserGroup> userGroups = new ArrayList<>();

    public ExerciseGroup() {

    }

    public void setExerciseGroup(String exerciseGroupName, String intro, User chief, String targetDay) {
        this.exerciseGroupName = exerciseGroupName;
        this.intro = intro;
        this.targetDay = targetDay;
        this.localDateTime = LocalDateTime.now();
        Attend attend = new Attend();
        attend.join(chief);
        attendList.add(attend);
    }
}
