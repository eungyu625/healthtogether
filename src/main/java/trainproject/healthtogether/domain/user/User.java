package trainproject.healthtogether.domain.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;
import trainproject.healthtogether.BaseTimeEntity;
import trainproject.healthtogether.domain.exercise.Record;
import trainproject.healthtogether.domain.group.ExerciseGroup;
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

    @Column
    private String picture;

    @Column
    private String nickName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    private Friend friendList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserGroup> userGroupList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

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

    public void addFriends(User user) {
        friendList.add(user);
    }

    public void removeFriends(User user) {
        friendList.remove(user);
    }

    public User findFriend(User user) {
        if (friendList.findOne(user) == null) {
            return null;
        }

        return user;
    }

    public List<User> findFriendsAll() {
        return friendList.findAll();
    }
}
