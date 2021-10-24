package mvc.practice.starter.services;

import lombok.RequiredArgsConstructor;
import mvc.practice.starter.dtos.UserDto;
import mvc.practice.starter.exceptions.NotFoundResourceException;
import mvc.practice.starter.models.User;
import mvc.practice.starter.repositories.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getSingleUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(NotFoundResourceException::new);
        return new UserDto(user);
    }


}
