package start.final_project_instagram.service;
import org.springframework.stereotype.Service;
import start.final_project_instagram.entities.User;
import java.util.List;
@Service
public interface FollowerService {
    List<User> search(String usernameOrFullName);
    User subscribe(Long userId, Long profileId);
    List<User> getAllSubscribersByUserId(Long userId);
    List<User> getAllSubscriptionsByUserId(Long userId);
}