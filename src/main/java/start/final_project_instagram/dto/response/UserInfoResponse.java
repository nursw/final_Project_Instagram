package start.final_project_instagram.dto.response;
import start.final_project_instagram.enums.Gender;
public record UserInfoResponse(
        Long id,
        String fullName,
        String biography,
        Gender gender,
        String image
) {
}