package start.final_project_instagram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);


    List<User> findByUsernameContainingOrFullNameContaining(String usernameOrFullName, String usernameOrFullName1);
}