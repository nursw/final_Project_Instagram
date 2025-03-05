package start.final_project_instagram.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import start.final_project_instagram.enums.Gender;
public record UserInfoRequest(
        @NotBlank(message = "Полное имя не должно быть пустым")
        @Size(max = 50, message = "Полное имя не должно превышать 50 символов")
        String fullName,
        @Size(max = 500, message = "Биография не должна превышать 500 символов")
        String biography,
        @NotNull(message = "Пол не может быть null")
        Gender gender,
        @NotBlank(message = "URL аватарки не должен быть пустым")
        @Pattern(
                regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
                message = "Неверный формат URL изображения"
        )
        String image
) {
}