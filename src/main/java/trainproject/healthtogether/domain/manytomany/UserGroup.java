package trainproject.healthtogether.domain.manytomany;

import lombok.Getter;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
public class UserGroup {

    @Id
    @GeneratedValue
    @Column(name = "userGroup_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exerciseGroup_id")
    private ExerciseGroup exerciseGroup;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    protected UserGroup() {

    }

    public UserGroup(ExerciseGroup exerciseGroup, User user) {
        this.exerciseGroup = exerciseGroup;
        this.user = user;
    }
}
