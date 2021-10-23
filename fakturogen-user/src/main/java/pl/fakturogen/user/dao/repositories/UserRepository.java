package pl.fakturogen.user.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.user.dao.entity.User;

/**
 * @author ewa-git
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
