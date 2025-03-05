package start.final_project_instagram.dto.response;
public record PostResponse(
        Long id,
        String title,
        String description,
        String createdAt
) {
}