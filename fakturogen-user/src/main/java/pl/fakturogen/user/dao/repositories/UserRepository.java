package pl.fakturogen.user.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fakturogen.user.dao.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
