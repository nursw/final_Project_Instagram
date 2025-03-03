package start.final_project_instagram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.Image;
import start.final_project_instagram.entities.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Image> findByUserId(Long userId);
}