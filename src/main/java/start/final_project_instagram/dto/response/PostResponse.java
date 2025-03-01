package start.final_project_instagram.dto.response;

import java.util.List;

public class PostResponseDto {
    private Long id;
    private String title;
    private String description;
    private String createdAt;
    private Long userId;
    private List<String> taggedUsers;
    private List<ImageResponseDto> images;
}
