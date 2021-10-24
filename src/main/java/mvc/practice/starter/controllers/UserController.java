package mvc.practice.starter.controllers;

import lombok.RequiredArgsConstructor;
import mvc.practice.starter.dtos.UserDto;
import mvc.practice.starter.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto getSingleUser(@PathVariable Long id) {
        return userService.getSingleUser(id);
    }
}
