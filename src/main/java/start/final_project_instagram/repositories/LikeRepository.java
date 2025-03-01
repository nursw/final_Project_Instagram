package start.final_project_instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.Like;
@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    void deleteByCommentId(Long isLikeId);
}
