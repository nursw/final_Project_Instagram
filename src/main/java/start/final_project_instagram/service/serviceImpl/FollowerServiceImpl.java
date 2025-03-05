package start.final_project_instagram.service.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.final_project_instagram.entities.Follower;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.repositories.FollowerRepository;
import start.final_project_instagram.repositories.UserRepository;
import start.final_project_instagram.service.FollowerService;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class FollowerServiceImpl implements FollowerService {
    private final FollowerRepository followerRepository;
    private final UserRepository userRepository;
    @Override
    public List<User> search(String usernameOrFullName) {
        return userRepository.findByUsernameContainingOrUserInfoFullNameContaining(usernameOrFullName, usernameOrFullName);
    }
    @Override
    public User subscribe(Long userId, Long profileId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<User> profileOpt = userRepository.findById(profileId);
        if (userOpt.isPresent() && profileOpt.isPresent()) {
            User user = userOpt.get();
            User profile = profileOpt.get();
            Follower follower = followerRepository.findByUserId(userId)
                    .orElse(new Follower(user, null, null));
            if (follower.getSubscriptions().contains(profile)) {
                follower.getSubscriptions().remove(profile);
            } else {
                follower.getSubscriptions().add(profile);
            }
            followerRepository.save(follower);
            return profile;
        }
        throw new RuntimeException("User or profile not found");
    }
    @Override
    public List<User> getAllSubscribersByUserId(Long userId) {
        Follower follower = followerRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Followers not found for user with id " + userId));
        return follower.getSubscribers();
    }
    @Override
    public List<User> getAllSubscriptionsByUserId(Long userId) {
        Follower follower = followerRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Subscriptions not found for user with id " + userId));
        return follower.getSubscriptions();
    }
}