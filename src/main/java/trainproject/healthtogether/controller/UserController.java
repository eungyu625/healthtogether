package trainproject.healthtogether.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import trainproject.healthtogether.domain.user.User;
import trainproject.healthtogether.dto.UserModifyRequestDto;
import trainproject.healthtogether.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PutMapping
    public ResponseEntity<Long>  modify(@AuthenticationPrincipal User user, @RequestBody UserModifyRequestDto dto) {

        Long response = userService.modifyUser(user, dto);

        return ResponseEntity.ok()
                .body(response);
    }
}
