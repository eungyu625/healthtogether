package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
public class Attend {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ElementCollection
    private Map<User, Double> attendance = new HashMap<>();

    public void newMember(User user) {
        attendance.put(user, 0.);
    }

    public void attend(User user) {
        LocalDate startDate = group.getGroupJoinDate().get(user);

    }
}
