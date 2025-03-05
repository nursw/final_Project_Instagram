package start.final_project_instagram.dto.request;
import jakarta.validation.constraints.NotNull;
public record LikeRequest(
        @NotNull(message = "Like не может быть null")
        boolean isLike
) {
}