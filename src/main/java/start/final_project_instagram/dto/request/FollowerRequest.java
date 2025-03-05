package start.final_project_instagram.dto.request;
import jakarta.validation.constraints.NotNull;
public record FollowerRequest(
        @NotNull(message = "Follower ID не может быть null")
        Long followerId,
        @NotNull(message = "User ID не может быть null")
        Long userId
) {
}