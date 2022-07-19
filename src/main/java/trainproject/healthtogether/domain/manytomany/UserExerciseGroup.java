package trainproject.healthtogether.domain.manytomany;

import lombok.Getter;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
public class UserExerciseGroup {

    @Id
    @GeneratedValue
    @Column(name = "userExerciseGroup_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exerciseGroup_id")
    private ExerciseGroup exerciseGroup;

    protected UserExerciseGroup() {

    }

    public UserExerciseGroup(User user, ExerciseGroup exerciseGroup) {
        this.user = user;
        this.exerciseGroup = exerciseGroup;
    }
}
