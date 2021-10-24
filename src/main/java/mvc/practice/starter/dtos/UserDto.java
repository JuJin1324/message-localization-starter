package mvc.practice.starter.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvc.practice.starter.models.User;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private Integer age;

    public UserDto(User user) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
