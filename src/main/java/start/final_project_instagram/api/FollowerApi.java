package start.final_project_instagram.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.service.FollowerService;

import java.util.List;
@RestController
@RequestMapping("/api/followers")
@RequiredArgsConstructor
public class FollowerApi {
    private final FollowerService followerService;

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String query) {
        return ResponseEntity.ok(followerService.search(query));
    }

    @PostMapping("/subscribe/{userId}/{profileId}")
    public ResponseEntity<User> subscribe(@PathVariable Long userId, @PathVariable Long profileId) {
        return ResponseEntity.ok(followerService.subscribe(userId, profileId));
    }

    @GetMapping("/subscribers/{userId}")
    public ResponseEntity<List<User>> getSubscribers(@PathVariable Long userId) {
        return ResponseEntity.ok(followerService.getAllSubscribersByUserId(userId));
    }

    @GetMapping("/subscriptions/{userId}")
    public ResponseEntity<List<User>> getSubscriptions(@PathVariable Long userId) {
        return ResponseEntity.ok(followerService.getAllSubscriptionsByUserId(userId));
    }
}