package start.final_project_instagram.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.UserInfo;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}