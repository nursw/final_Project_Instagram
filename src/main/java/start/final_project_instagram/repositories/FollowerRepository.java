package start.final_project_instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import start.final_project_instagram.entities.Follower;
import start.final_project_instagram.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {
    Optional<Follower> findById(Long userId);
//    int countByUser(User user);
//    int countByFollower(User user);
//    Optional<Follower> findByFollowerAndUser(User follower, User user);
//    @Query("SELECT f.follower FROM Followers f WHERE f.user.id = :userId")
//    List<User> findAllSubscribersByUserId(@Param("userId") Long userId);
//
//    @Query("SELECT f.user FROM Follower f WHERE f.follower.id = :userId")
//    List<User> findAllSubscriptionsByUserId(@Param("userId") Long userId);

}
