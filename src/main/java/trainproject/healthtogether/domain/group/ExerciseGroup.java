package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Getter
public class ExerciseGroup {

    @Id
    @GeneratedValue
    @Column(name = "exerciseGroup_id")
    private Long id;

    private String exerciseGroupName;

    private String intro;

    private int routineTime;

    private LocalDate startDate;

    private String targetDay;

    @OneToMany
    @MapKeyColumn(name = "user_id")
    private Map<User, Attend> memberList = new ConcurrentHashMap<>();

    @OneToMany(mappedBy = "exerciseGroup")
    private List<UserGroup> userGroups = new ArrayList<>();

    public ExerciseGroup() {

    }

    public void setExerciseGroup(String exerciseGroupName, String intro, User chief, String targetDay, int routineTime) {
        this.exerciseGroupName = exerciseGroupName;
        this.intro = intro;
        this.targetDay = targetDay;
        this.routineTime = routineTime;
        this.startDate = LocalDate.now();
        this.memberList.put(chief, new Attend());
    }

    public void joinExerciseGroup(User member) {
        this.memberList.put(member, new Attend());
    }

    public void attend(User user) {
        memberList.get(user).attend();
    }

    public Integer memberAttendRate(User user) {
        return memberList.get(user).attendanceRate();
    }

    public Long groupAttendRate() {
        long attendRate = 0;

        for (User user : memberList.keySet()) {
            attendRate += (long) memberList.get(user).attendanceRate();
        }

        return 100 * attendRate / memberList.size();
    }
}
