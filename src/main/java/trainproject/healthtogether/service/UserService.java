package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addFriends(User user, User friend) {

        user.addFriends(friend);
    }

    public void removeFriends(User user, User friend) {

        user.removeFriends(friend);
    }

    public List<User> findFriends(User user) {

        return user.findFriendsAll();
    }

    public List<ExerciseGroup> findExerciseGroupList(User user) {

        List<ExerciseGroup> exerciseGroupList = new ArrayList<>();

        for (UserGroup userGroup : user.getUserGroupList()) {
            exerciseGroupList.add(userGroup.getExerciseGroup());
        }

        return exerciseGroupList;
    }
}
