package trainproject.healthtogether.domain.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.BaseTimeEntity;
import trainproject.healthtogether.domain.exercise.Record;
import trainproject.healthtogether.domain.group.Group;
import trainproject.healthtogether.dto.UserForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@SequenceGenerator(name = "User_SEQ_GEN",sequenceName = "User_SEQ")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_SEQ")
    @Column(name = "user_id")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String picture;

    @Column
    private String nickName;


    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    @JoinColumn(name = "group_id")
    private List<Group> group = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Record> records = new ArrayList<>();

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    protected User() {
    }

    public User update(String name, String picture){
        this.name =name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

    @Transactional
    public User updateProfile(UserForm userForm){
        if(!userForm.getEmail().isEmpty())
            this.role=Role.USER;  //정식 승인
        this.email = userForm.getEmail();
        this.nickName = userForm.getNickName();
        return this;
    }

}
