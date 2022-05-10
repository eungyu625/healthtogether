package trainproject.healthtogether.domain.group;

import lombok.Getter;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private String groupName;

    private String days;

    private String intro;

    private LocalDateTime startDateTime;

    @Embedded
    private Attend attend;

    @ManyToMany(mappedBy = "group")
    private List<User> users = new ArrayList<>();

    public void setGroup(String groupName, String days, String intro) {
        this.groupName = groupName;
        this.days = days;
        this.intro = intro;
        this.startDateTime = LocalDateTime.now();
    }
}
