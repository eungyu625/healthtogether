package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Embeddable
@Getter
public class Attend {

    private Map<User, Integer> attendance = new HashMap<>();

    public void attend(User user) {
        attendance.put(user, attendance.get(user) + 1);
    }

    public Double getAttendRate(User user) {
        int attends = attendance.get(user);
        return 0.0;
    }
}
