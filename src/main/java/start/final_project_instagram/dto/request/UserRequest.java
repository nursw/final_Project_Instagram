package start.final_project_instagram.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public record UserRequest(
        @NotBlank(message = "Username не должен быть пустым")
        @Size(min = 3, max = 20, message = "Длина username должна быть от 3 до 20 символов")
        String username,
        @NotBlank(message = "Пароль не должен быть пустым")
        @Size(min = 8, message = "Пароль должен содержать минимум 8 символов")
        String password,
        @NotBlank(message = "Email не должен быть пустым")
        @Email(message = "Неверный формат email")
        String email,
        @NotBlank(message = "Номер телефона не должен быть пустым")
        @Size(min = 10, max = 15, message = "Номер телефона должен содержать от 10 до 15 символов")
        String phoneNumber
) {
}