package start.final_project_instagram.dto.response;
public record CommentResponse(
        Long id,
        String comment,
        String createdAt
) {
}