package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Attend {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseGroup_id")
    private ExerciseGroup exerciseGroup;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime joinDateTime;

    private Integer attendDays;

    public void join(User user) {
        this.user = user;
        this.joinDateTime = LocalDateTime.now();
        this.attendDays = 0;
    }

    public void attend() {
        attendDays++;
    }
}
