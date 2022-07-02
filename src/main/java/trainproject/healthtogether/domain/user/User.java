package trainproject.healthtogether.domain.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.BaseTimeEntity;
import trainproject.healthtogether.domain.manytomany.UserGroup;
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserGroup> userGroupList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    protected User() {
    }

    public User update(String name){
        this.name =name;
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
        return this;
    }
}
