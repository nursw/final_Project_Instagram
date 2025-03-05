package start.final_project_instagram.dto.response;
import java.util.List;
public record FollowerResponse(
        Long id,
        List<Long> subscribers,
        List<Long> subscriptions
) {
}