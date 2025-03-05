package start.final_project_instagram.dto.response;
public record UserResponse(
        Long id,
        String username,
        String email,
        String phoneNumber
) {
}