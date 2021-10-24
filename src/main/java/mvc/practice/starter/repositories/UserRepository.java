package mvc.practice.starter.repositories;

import mvc.practice.starter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yoo Ju Jin(jujin1324@daum.net)
 * Created Date : 2021/10/24
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
