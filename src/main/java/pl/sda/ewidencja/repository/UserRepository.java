package pl.sda.ewidencja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.ewidencja.domain.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
