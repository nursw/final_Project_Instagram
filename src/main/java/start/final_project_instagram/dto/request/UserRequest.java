package start.final_project_instagram.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

@Data
public class UserRequestDto {
    @NotBlank(message = "Имя пользователя не должно быть пустым")
    private String username;

    @NotBlank(message = "Пароль не должен быть пустым")
    private String password;

    @Email(message = "Некорректный email")
    private String email;

    @Pattern(regexp = "^\\+996\\d{9}$", message = "Номер телефона должен начинаться с +996 и содержать 13 символов")
    private String phoneNumber;
}
