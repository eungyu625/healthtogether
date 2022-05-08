package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Entity
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    @ElementCollection
    private List<String> target_days;

    private String intro;

    private LocalDate startDate;

    @OneToOne(mappedBy = "group")
    private Attend attend;

    private Double attendanceRate;

    @ElementCollection
    private Map<User, LocalDate> groupJoinDate = new HashMap<>();

    @OneToMany(mappedBy = "group")
    private List<User> users = new ArrayList<>();

    public void setGroup(String intro, List<String> target_days) {
        this.intro = intro;
        this.target_days.addAll(target_days);
        this.startDate = LocalDate.now();
    }

    public void joinGroup(User user) {
        users.add(user);
        groupJoinDate.put(user, LocalDate.now());
    }

    // 전체 출석율 로직
    public void setAttendanceRate() {

    }
}
