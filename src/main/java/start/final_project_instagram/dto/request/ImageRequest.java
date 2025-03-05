package start.final_project_instagram.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
public record ImageRequest(
        @NotBlank(message = "URL изображения не должен быть пустым")
        @Pattern(
                regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
                message = "Неверный формат URL изображения"
        )
        String imageUrl
) {
}