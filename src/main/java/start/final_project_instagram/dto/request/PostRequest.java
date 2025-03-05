package start.final_project_instagram.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record PostRequest(
        @NotBlank(message = "Заголовок не должен быть пустым")
        @Size(max = 100, message = "Заголовок не должен превышать 100 символов")
        String title,
        @NotBlank(message = "Описание не должно быть пустым")
        String description
) {
}