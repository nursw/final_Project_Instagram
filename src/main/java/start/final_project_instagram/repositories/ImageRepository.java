package start.final_project_instagram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.Image;
import start.final_project_instagram.entities.User;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<User, Long> {
    List<User> findByUsernameOrFullName(String username, String fullName);
}