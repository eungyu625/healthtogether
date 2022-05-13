package trainproject.healthtogether.domain.user;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Friend {

    @Id
    @GeneratedValue
    @Column(name = "friend_id")
    private Long id;

    @OneToMany(mappedBy = "friendList")
    private List<User> friendList = new ArrayList<>();

    public void add(User user) {
        friendList.add(user);
    }

    public void remove(User user) {
        friendList.remove(user);
    }

    public List<User> findAll() {
        return friendList;
    }

    public User findOne(User user) {
        if (!friendList.contains(user)) {

            return null;
        }

        return user;
    }
}
