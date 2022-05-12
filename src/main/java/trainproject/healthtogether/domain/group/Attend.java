package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Entity
@Getter
public class Attend {

    @Id
    @GeneratedValue
    @Column(name = "attend_id")
    private Long id;

    private LocalDateTime joinDate;

    private Integer attendanceDays;

    public Attend() {
        joinDate = LocalDateTime.now();
        attendanceDays = 0;
    }

    public void attend() {
        attendanceDays++;
    }

    public Double attendanceRate() {
        return 0.;
    }
}
