package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.manytomany.UserGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.UserModifyRequestDto;
import trainproject.healthtogether.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<ExerciseGroup> findExerciseGroupList(User user) {

        List<ExerciseGroup> exerciseGroupList = new ArrayList<>();

        for (UserGroup userGroup : user.getUserGroupList()) {
            exerciseGroupList.add(userGroup.getExerciseGroup());
        }

        return exerciseGroupList;
    }

    public Long modifyUser(User user, UserModifyRequestDto dto) {

        user.setNickName(dto.getNickName());
        user.setPicture(dto.getPicture());

        userRepository.saveAndFlush(user);

        return 0L;
    }
}
