package mvc.practice.starter.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */

@Entity
@Table(name = "USER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
