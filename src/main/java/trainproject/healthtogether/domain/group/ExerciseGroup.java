package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    private LocalDate startDate;

    private String targetDay;

    private String video_title;

    private String video_url;

    private Long count;

    private Long groupAttendRate = 0L;

    @OneToOne(fetch = FetchType.LAZY)
    private User chief;

    @OneToMany(cascade = CascadeType.ALL)
    @MapKeyColumn(name = "user_id")
    private Map<User, Attend> attendList = new ConcurrentHashMap<>();

    @OneToMany(mappedBy = "exerciseGroup")
    private List<User> memberList = new ArrayList<>();

    @OneToMany(mappedBy = "exerciseGroup")
    private List<UserGroup> userGroupList = new ArrayList<>();

    public ExerciseGroup() {

    }

    public void setExerciseGroup(String exerciseGroupName, String video_title, String video_url, String targetDay, Long count, String intro, User chief) {
        this.exerciseGroupName = exerciseGroupName;
        this.intro = intro;
        this.video_title = video_title;
        this.video_url = video_url;
        this.targetDay = targetDay;
        this.count = count;
        this.startDate = LocalDate.now();
        this.chief = chief;
        this.attendList.put(chief, new Attend());
        this.memberList.add(chief);
    }

    public void joinExerciseGroup(User member) {

        this.attendList.put(member, new Attend());
        this.memberList.add(member);
    }

    public void attend(User user) {
        attendList.get(user).attend();
    }

    public Integer memberAttendRate(User user) {
        return attendList.get(user).attendanceRate();
    }

    public void setGroupAttendRate() {
        long attendRate = 0;

        for (User user : attendList.keySet()) {
            attendRate += (long) attendList.get(user).attendanceRate();
        }

        groupAttendRate =  100 * attendRate / attendList.size();
    }

    public void withdrawalMember(User user) {

        attendList.remove(user);
        memberList.remove(user);
    }

}
