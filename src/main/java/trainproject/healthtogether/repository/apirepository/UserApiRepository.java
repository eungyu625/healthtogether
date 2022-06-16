package trainproject.healthtogether.repository.apirepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.FriendDto;
import trainproject.healthtogether.dto.UserDto;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserApiRepository {

    private EntityManager em;

    public List<UserDto> findMemberList(ExerciseGroup exerciseGroup) {

        List<UserDto> result = new ArrayList<>();

        for (UserGroup userGroup : exerciseGroup.getUserGroupList()) {
            result.add(new UserDto(userGroup.getUser().getId(), userGroup.getUser().getName(), userGroup.getUser().getEmail(), userGroup.getUser().getPicture(), userGroup.getUser().getNickName(),
                    userGroup.getUser().getFriendList(), userGroup.getUser().getUserGroupList()));
        }

        return result;
    }

    public List<FriendDto> findFriendList(User user) {

        List<FriendDto> result = new ArrayList<>();

        for (User friend : user.getFriendList().findAll()) {
            result.add(new FriendDto(friend.getId(), friend.getName(), friend.getEmail(), friend.getPicture(), friend.getNickName()));
        }

        return result;
    }

}
