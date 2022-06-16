package trainproject.healthtogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import trainproject.healthtogether.dto.FriendDto;
import trainproject.healthtogether.repository.apirepository.UserApiRepository;
import trainproject.healthtogether.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserApiRepository userApiRepository;

    public void getFriendListAll() {

    }

    public void addFriend() {

    }

    public void removeFriend() {

    }
}
