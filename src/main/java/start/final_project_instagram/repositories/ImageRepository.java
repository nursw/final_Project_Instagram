package start.final_project_instagram.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}