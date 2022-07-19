package trainproject.healthtogether.domain.group;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
public class Attend {

    @Id
    @GeneratedValue
    @Column(name = "attend_id")
    private Long id;

    private LocalDate joinDate;

    private Integer attendanceDays;

    public Attend() {
        joinDate = LocalDate.now();
        attendanceDays = 0;
    }

    public void attend() {
        attendanceDays++;
    }

    public Integer attendanceRate() {
        Integer workDays = Long.valueOf(ChronoUnit.DAYS.between(joinDate, LocalDate.now())).intValue() + 1;
        return 100 * attendanceDays / workDays;
    }
}
