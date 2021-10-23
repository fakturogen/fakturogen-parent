package pl.fakturogen.user.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fakturogen.user.dao.entity.UserExternalApi;

/**
 * @author ewa-git
 */

public interface UserExternalApiRepository extends JpaRepository<UserExternalApi, Long> {
}
