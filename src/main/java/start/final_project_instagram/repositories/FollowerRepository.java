package start.final_project_instagram.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.Follower;
import java.util.Optional;
@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {
    Optional<Follower> findByUserId(Long userId);
}