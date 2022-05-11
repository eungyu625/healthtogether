package trainproject.healthtogether.domain.manytomany;

import lombok.Getter;
import lombok.Setter;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.User;

import javax.persistence.*;

@Entity
@Getter @Setter
public class UserGroup {

    @Id
    @GeneratedValue
    @Column(name = "usergroup_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseGroup_id")
    private ExerciseGroup exerciseGroup;

}
