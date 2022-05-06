package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private Long id;

    private List<String> target_days;
    private String intro;
    private List<Attend> attend;
    private Double attendanceRate;

    @OneToMany(mappedBy = "group")
    private List<User> users = new ArrayList<>();

    public void setGroup(String intro, List<String> target_days) {
        this.intro = intro;
        this.target_days.addAll(target_days);
    }

    // 전체 출석율 로직
    public void setAttendanceRate() {

    }
}
