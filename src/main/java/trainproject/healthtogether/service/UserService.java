package trainproject.healthtogether.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import trainproject.healthtogether.domain.group.ExerciseGroup;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
