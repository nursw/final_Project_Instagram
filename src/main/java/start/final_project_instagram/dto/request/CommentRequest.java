package start.final_project_instagram.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record CommentRequest(
        @NotBlank(message = "Комментарий не должен быть пустым")
        @Size(max = 500, message = "Комментарий не должен превышать 500 символов")
        String comment
) {
}